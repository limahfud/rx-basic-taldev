package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_combine_latest.*
import me.mahfud.rxtalentdev.R

class CombineLatestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combine_latest)

        Log.d("TALDEV", "Opening Activity: Combine Latest Operator")

        val tenStream = PublishSubject.create<Int>()
        val oneStream = PublishSubject.create<Int>()


        Observable.combineLatest(tenStream, oneStream, BiFunction<Int, Int, String> { t1, t2 -> "$t1 + $t2 = ${t1 + t2}" }).
                subscribe { x ->
            Log.d("TALDEV", "item: " + x)
        }

        btn10.setOnClickListener { tenStream.onNext(10) }
        btn20.setOnClickListener { tenStream.onNext(20) }
        btn30.setOnClickListener { tenStream.onNext(30) }

        btn1.setOnClickListener { oneStream.onNext(1) }
        btn2.setOnClickListener { oneStream.onNext(2) }
        btn3.setOnClickListener { oneStream.onNext(3) }
    }
}
