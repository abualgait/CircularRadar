# CircularRadar
ShareIt like radar UI connect avatars statically in xml or programmatically. 

*I got attracted by an interesting UI at slack online community @MindOrks and tried to create it.
firstly i thought about inflating customviews, but i figured an easy clean way to create this view staticky or dynamically via constraint-layout.
you can use the following attributes to center views to certain view and also by using ConstraintSet you can set these attrs dynamically.
hope it helps.*
```
app:layout_constraintCircle="@id/center_image"
app:layout_constraintCircleAngle="45"
app:layout_constraintCircleRadius="150dp"
```     
<img src="https://github.com/abualgait/CircularRadar/blob/master/circular_radar.png"  width="210" height="390" >
 
 
