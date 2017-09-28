package cat.dream.common

import java.io.File
import java.net.URLDecoder
import java.util.ResourceBundle

/**
  * 基本配置信息
  *
  * @author solitudesword
  */
object BaseConfig {
    /**
      * 获取项目的根目录
      *
      * @return 项目根目录
      */
    def getProjectRootDir: String = ResourceBundle.getBundle("base").getString("project.rootdir") + "/../"

    /**
      * 获取当前module的根目录
      *
      * @return 目录
      * @note 当前module是指调用方
      */
    def getModuleDir: String = {
        val path = URLDecoder.decode(
            new File(BaseConfig.getClass.getClassLoader.getResource("").getFile).getAbsolutePath,
            "utf-8")
        path.substring(0, path.lastIndexOf("target"))
    }
}
