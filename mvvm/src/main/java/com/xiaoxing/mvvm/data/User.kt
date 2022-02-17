package com.xiaoxing.mvvm

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import cn.bmob.v3.BmobObject
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

/**

 *@Description: 用户
 *@Author: qushaohua
 *@CreateDate: 2022/1/17 10:15 上午

 */
class UserModel(
    //如果没有默认值，初始化时必须要传
    var name : String = "",
    var password : String = ""
) : BmobObject()


class UserInfo : BmobObject{
    var nickName : String = ""
    var sex : Int = 0

    //构造方法
    constructor(nickName : String){
        this.nickName = nickName
    }
    //构造方法
    constructor(nickName : String,sex : Int){
        this.nickName = nickName
        this.sex = sex
    }
}


@JvmName("inflateWithGeneric")
fun <VB : ViewBinding> AppCompatActivity.skdfjdk(layoutInflater: LayoutInflater): VB =
    withGenericBindingClass<VB>(this) { clazz ->
        clazz.getMethod("inflate", LayoutInflater::class.java).invoke(null, layoutInflater) as VB
    }.also { binding ->
        if (binding is ViewDataBinding) {
            binding.lifecycleOwner = this
        }
    }
private fun <VB : ViewBinding> withGenericBindingClass(any: Any, block: (Class<VB>) -> VB): VB {
    var genericSuperclass = any.javaClass.genericSuperclass
    var superclass = any.javaClass.superclass
    while (superclass != null) {
        if (genericSuperclass is ParameterizedType) {
            try {
                return block.invoke(genericSuperclass.actualTypeArguments[1] as Class<VB>)
            } catch (e: NoSuchMethodException) {
            } catch (e: ClassCastException) {
            } catch (e: InvocationTargetException) {
                throw e.targetException
            }
        }
        genericSuperclass = superclass.genericSuperclass
        superclass = superclass.superclass
    }
    throw IllegalArgumentException("There is no generic of ViewBinding.")
}
