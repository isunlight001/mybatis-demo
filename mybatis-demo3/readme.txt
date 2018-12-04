mybatis-demo3描述

此项目为集成并测试使用分页插件PageHelper

PageHelper的官网地址为：https://github.com/pagehelper/Mybatis-PageHelper

重要说明：
    1.本项目采用的是PageHelper 5.0版本以上的如果低于5.0版本是不适用的，所以请注意版本问题
    2.本项目配置PageHelper是采用mybatis-config.xml配置的，不是在Spring配置文件中配置的，
      所以如果要使用spring配置文件配置请参数官网例子，这里不做赘述，在以下地址查找。
      https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
    3.本项目会测试几种推荐的分页查询方式，但是不会全部测试，如果有特殊业务需求请查询官网文档