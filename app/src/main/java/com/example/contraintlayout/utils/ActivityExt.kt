package com.example.contraintlayout.utils

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.contraintlayout.R


/**
 * @author hungnt
 * @since 22/1/19.
 */

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment, fragment.javaClass.name)
    }
}

/**
 * Runs a FragmentTransaction, then calls commit().
 */
inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commitAllowingStateLoss()
}

fun AppCompatActivity.hideKeyboard() {
    val imm = getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(findViewById<View>(android.R.id.content)?.windowToken, 0)
}

fun AppCompatActivity.setupActionBar(toolbar: Toolbar, action: ActionBar.() -> Unit) {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        action()
    }
}

fun AppCompatActivity.showToast(msg: String) {
    android.widget.Toast.makeText(this, msg, android.widget.Toast.LENGTH_SHORT).show()
}


/**
 * Show dialog message with two buttons
 * & set click listener for positive button (dialog will be dismiss after callback called)
 * default click listener for negative button is dismiss dialog
 */
/*fun Activity.showDialogMsg(@StringRes message: Int,
                           @StringRes positiveButton: Int = R.string.button_ok,
                           @StringRes negativeButton: Int = R.string.button_dismiss,
                           onPositiveClickListener: View.OnClickListener? = null) {
    CustomDialog(this,
        getString(message),
        getString(positiveButton),
        getString(negativeButton),
        onPositiveClickListener).show()
}*/

fun AppCompatActivity.findOrCreateViewFragment(@IdRes id: Int, clazz: Class<out Fragment>): Fragment =
    supportFragmentManager.findFragmentById(id) ?: clazz.newInstance()

fun AppCompatActivity.showFragmentToActivity(fragment: Fragment, visible: Boolean) {
    supportFragmentManager.transact {
        if (visible) show(fragment) else hide(fragment)
    }
}

//fun Fragment.switchFragment(fragment: Fragment, replace: Int = R.id.frameContent) {
//    val name: String = fragment.javaClass.name
//    val ft: FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
//    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
//    ft.replace(replace, fragment)
//    ft.addToBackStack(name)
//    ft.commit()
//}
//
//fun AppCompatActivity.switchFragment(fragment: Fragment, replace: Int = R.id.frameContent) {
//    val name: String = fragment.javaClass.name
//    val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
//    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
//    ft.replace(replace, fragment)
//    ft.addToBackStack(name)
//    ft.commit()
//}

fun Fragment.replaceFragmentInFragment(fragment: Fragment, frameId: Int) {
    childFragmentManager.transact {
        replace(frameId, fragment, fragment.javaClass.name)
    }
}