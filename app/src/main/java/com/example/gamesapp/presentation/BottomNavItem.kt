package com.example.gamesapp.presentation


import com.example.gamesapp.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_baseline_home_24,"Drivers")
    object Hot: BottomNavItem("Hot", R.drawable.ic_baseline_video_library_24,"GrandPix")
    object Discover: BottomNavItem("Discover",R.drawable.ic_baseline_vibration_24,"Discover")
    object Profile: BottomNavItem("Profile",R.drawable.ic_baseline_person_24,"Profile")

}
