package com.abualgait.msayed.circularradar

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createAvatar(180f, 150.px, 40.px, R.drawable.photo_male_1)
        createAvatar(100f, 150.px, 40.px, R.drawable.photo_male_5)
        createAvatar(140f, 150.px, 40.px, R.drawable.photo_male_3)
    }

    private fun createAvatar(angle: Float, raduis: Int, size: Int, @DrawableRes img: Int) {
        val set = ConstraintSet()
        //create imageview
        val childView = CircleImageView(this)
        childView.setImageResource(img)
        val layoutParams = LinearLayout.LayoutParams(size, size)
        childView.layoutParams = layoutParams
        childView.id = View.generateViewId()
        container.addView(childView)
        //connect it via constraints
        set.clone(container)
        set.connect(childView.id, ConstraintSet.TOP, center_image.id, ConstraintSet.TOP)
        set.connect(childView.id, ConstraintSet.START, center_image.id, ConstraintSet.START)
        // you can control the angle and radius to prevent repetitive over same place
        set.constrainCircle(childView.id, center_image.id, raduis, angle)
        set.applyTo(container)
    }
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
