package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_distinct_until_changed.*
import me.mahfud.rxtalentdev.R

class DistinctUntilChangedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distinct_until_changed)

        Log.d("TALDEV", "Opening Activity: Distinct Until Changed Operator")

        val oneStream = PublishSubject.create<Int>()

        oneStream.distinctUntilChanged().subscribe { x ->
            Log.d("TALDEV", "item: " + x)
        }

        btn1.setOnClickListener { oneStream.onNext(1) }
        btn2.setOnClickListener { oneStream.onNext(2) }
        btn3.setOnClickListener { oneStream.onNext(3) }

        btnOneComplete.setOnClickListener { oneStream.onComplete() }
    }
}
