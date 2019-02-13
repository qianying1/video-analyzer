# -*-coding=utf-8 -*-
'''
properties属性文件操作工具
'''
import os


class Properties(object):
    '''
    设置属性文件的位置
    '''
    APPLICATION_LOCATION = None
    '''
    获取当前文件的路径
    :param st
    '''

    @staticmethod
    def __getDict(str_name, dict_name, value):
        if (str_name.find('.') > 0):
            k = str_name.split('.')[0]
            dict_name.setdefault(k, {})
            return Properties.__getDict(str_name[len(k) + 1:], dict_name[k], value)
        else:
            dict_name[str_name] = value
            return

    '''
    获取当前对象的属性文件中的属性
    默认的优先级如下：script根目录下的设置的APPLICATION_LOCATION位置为最高级,当前目录次之，script目录下的application.properties优先级最低
    :param file_path 属性文件路径
    '''

    @staticmethod
    def get_properties(file_path=None):
        properties = None
        if file_path is None or file_path.strip() == '':
            parent = ''
            base = '..'
            properties_read = False
            while not properties_read:
                if Properties.APPLICATION_LOCATION is None or Properties.APPLICATION_LOCATION.strip() == '':
                    parent_dir = os.path.abspath(
                        os.path.join(os.path.dirname(__file__), parent))
                    try:
                        direction = parent_dir + '\\db.properties'
                        properties = Properties.get_absolute_properties(direction)
                    except IOError as e:
                        if properties is None and not parent_dir.endswith('script'):
                            if base != '..':
                                parent = parent + "/.."
                            else:
                                parent = base
                                base = ''
                            continue
                    if properties is None and not parent_dir.endswith('main') and not parent.endswith('resources'):
                        if base != '..':
                            parent = parent + "/.."
                        else:
                            parent = base
                            base = ''
                        continue
                    if parent_dir.endswith('main') and properties is None and not parent.endswith('resources'):
                        parent = parent + '/resources'
                        continue
                else:
                    file_path = Properties.APPLICATION_LOCATION
                    properties = Properties.get_absolute_properties(file_path)
                properties_read = True
        else:
            properties = Properties.get_absolute_properties(file_path)
        return properties

    '''
    根据文件路径获取对应的properties属性文件中的属性
    :param file_path 文件路径
    '''

    @staticmethod
    def get_absolute_properties(file_path):
        if file_path is None or file_path.strip() == '':
            return None
        properties = {}
        file_path = file_path.replace('\\', '\\\\')
        try:
            pro_file = open(file_path, 'Ur')
            if pro_file is None:
                return None
            for line in pro_file.readlines():
                line = line.strip().replace('\n', '')
                if line.find("#") != -1:
                    line = line[0:line.find('#')]
                if line.find('=') > 0:
                    strs = line.split('=')
                    strs[1] = line[len(strs[0]) + 1:]
                    Properties.__getDict(strs[0].strip(), properties, strs[1].strip())
        except Exception as e:
            properties = None
        else:
            pro_file.close()
        if properties == {}:
            properties = None
        return properties


if '__main__' == __name__:
    dictProperties = Properties.get_properties()
    print dictProperties
