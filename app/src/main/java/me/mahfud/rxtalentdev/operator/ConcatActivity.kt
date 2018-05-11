package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import me.mahfud.rxtalentdev.R
import java.util.concurrent.TimeUnit

class ConcatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concat)

        Log.d("TALDEV", "Opening Activity: Concat Operator")

        val oneStream = Observable.just(1,1,1).delay(300, TimeUnit.MILLISECONDS)
        val twoStream = Observable.just('a','b' )

        Observable.concat(oneStream, twoStream).subscribe {
            x -> Log.d("TALDEV", "item: " + x)
        }

        Observable.zip(oneStream, twoStream, BiFunction<Int, Char, String> { t1, t2 -> "$t1  $t2" }).subscribe {
            x -> Log.d("TALDEV", "item(ZIP): " + x)
        }

        Observable.merge(oneStream, twoStream).subscribe {
            x -> Log.d("TALDEV", "item(MERGE): " + x)
        }


    }
}
