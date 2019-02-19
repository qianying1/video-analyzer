# -*- coding=utf-8 -*-
'''
非json格式的参数异常
'''


class NotJsonFormatError(TypeError):
    '''
    初始化异常
    :param errorinfo 异常信息
    '''

    def __init__(self, errorinfo):
        super.__init__(self)
        self.errorinfo = errorinfo
        self.message = self.message + errorinfo

    '''
    获取当前异常简略信息
    '''

    def errorinfo(self):
        return self.errorinfo()

    '''
    获取当前异常详细信息
    '''

    def message(self):
        return self.message()
