package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_zip.*
import me.mahfud.rxtalentdev.R

class ZipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zip)

        Log.d("TALDEV", "Opening Activity: Zip Operator")

        val tenStream = PublishSubject.create<Int>()
        val oneStream = PublishSubject.create<Int>()


        Observable.zip(tenStream, oneStream, BiFunction<Int, Int, String> { t1, t2 -> "$t1 + $t2 = ${t1 + t2}" }).
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
