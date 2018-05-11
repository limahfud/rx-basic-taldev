package me.mahfud.rxtalentdev.operator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_debounce.*
import me.mahfud.rxtalentdev.R
import java.util.concurrent.TimeUnit

class DebounceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debounce)

        Log.d("TALDEV", "Opening Activity: Debounce Operator")

        val oneStream = PublishSubject.create<Int>()

        oneStream.debounce(400, TimeUnit.MILLISECONDS).
                subscribe { x ->
                    Log.d("TALDEV", "item: " + x)
                }

        oneStream.throttleFirst(400, TimeUnit.MILLISECONDS).
                subscribe { x ->
                    Log.d("TALDEV", "throttle: " + x)
                }


        btn1.setOnClickListener { oneStream.onNext(1) }
        btn2.setOnClickListener { oneStream.onNext(2) }
        btn3.setOnClickListener { oneStream.onNext(3) }

        btnOneComplete.setOnClickListener { oneStream.onComplete() }

    }
}
