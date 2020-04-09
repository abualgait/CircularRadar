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

        //create imageview
        val childView = CircleImageView(this).apply {
            setImageResource(img)
            val lp = LinearLayout.LayoutParams(size, size)
            layoutParams = lp
            id = View.generateViewId()
            container.addView(this)
        }
        //connect it via constraints
        ConstraintSet().apply {
            clone(container)
            connect(childView.id, ConstraintSet.TOP, center_image.id, ConstraintSet.TOP)
            connect(childView.id, ConstraintSet.START, center_image.id, ConstraintSet.START)
            // you can control the angle and radius to prevent repetitive over same place
            constrainCircle(childView.id, center_image.id, raduis, angle)
            applyTo(container)
        }

    }
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
