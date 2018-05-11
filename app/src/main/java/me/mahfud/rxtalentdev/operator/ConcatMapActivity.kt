package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import me.mahfud.rxtalentdev.R
import java.util.Random
import java.util.concurrent.TimeUnit

class ConcatMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concat_map)

        Log.d("TALDEV", "Opening Activity: Concat Map")


        Observable.just(1, 2, 3, 4, 5, 6,7,8, 9 , 10)
                .switchMap { x ->
                    val delay = Random().nextInt(1000).toLong()
                    Observable.just(x * 10).delay(delay, TimeUnit.MILLISECONDS)
                }
                .subscribe {
                    x -> Log.d("TALDEV", "item: " + x)
                }
    }
}
