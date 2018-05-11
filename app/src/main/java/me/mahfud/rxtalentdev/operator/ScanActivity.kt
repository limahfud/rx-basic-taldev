package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_scan.*
import me.mahfud.rxtalentdev.R

class ScanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        Log.d("TALDEV", "Opening Activity: Scan Operator")

        val oneStream = PublishSubject.create<Int>()

        oneStream.scan { t1: Int, t2: Int -> t1 + t2 }.
                subscribe { x ->
                    Log.d("TALDEV", "item: " + x)
                }

        btn1.setOnClickListener { oneStream.onNext(1) }
        btn2.setOnClickListener { oneStream.onNext(2) }
        btn3.setOnClickListener { oneStream.onNext(3) }
    }
}
