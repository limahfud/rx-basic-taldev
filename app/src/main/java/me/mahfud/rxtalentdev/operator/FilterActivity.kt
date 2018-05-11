package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import me.mahfud.rxtalentdev.R

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        Log.d("TALDEV", "Opening Activity: Filter Operator")



        Observable.just(1, 2, 3, 4, 5, 6,7,8, 9 , 10)
                .filter { x -> x > 5 }
                .subscribe {
                    x -> Log.d("TALDEV", "item: " + x)
                }
    }
}
