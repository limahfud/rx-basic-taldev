package me.mahfud.rxtalentdev

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.mahfud.rxtalentdev.operator.CombineLatestActivity
import me.mahfud.rxtalentdev.operator.ConcatActivity
import me.mahfud.rxtalentdev.operator.ConcatMapActivity
import me.mahfud.rxtalentdev.operator.DebounceActivity
import me.mahfud.rxtalentdev.operator.DefaultIfEmptyActivity
import me.mahfud.rxtalentdev.operator.DistinctActivity
import me.mahfud.rxtalentdev.operator.DistinctUntilChangedActivity
import me.mahfud.rxtalentdev.operator.FilterActivity
import me.mahfud.rxtalentdev.operator.FlatMapActivity
import me.mahfud.rxtalentdev.operator.MapActivity
import me.mahfud.rxtalentdev.operator.ReduceActivity
import me.mahfud.rxtalentdev.operator.ScanActivity
import me.mahfud.rxtalentdev.operator.TakeUntilActivity
import me.mahfud.rxtalentdev.operator.ZipActivity
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLinkFilter.setOnClickListener { startActivity<FilterActivity>() }
        btnLinkMap.setOnClickListener { startActivity<MapActivity>() }
        btnLinkFlatMap.setOnClickListener { startActivity<FlatMapActivity>() }
        btnLinkConcatMap.setOnClickListener { startActivity<ConcatMapActivity>() }
        btnLinkConcat.setOnClickListener { startActivity<ConcatActivity>() }
        btnLinkCombineLatest.setOnClickListener { startActivity<CombineLatestActivity>() }
        btnLinkZip.setOnClickListener { startActivity<ZipActivity>() }
        btnLinkScan.setOnClickListener { startActivity<ScanActivity>() }
        btnLinkReduce.setOnClickListener { startActivity<ReduceActivity>() }
        btnLinkDebounce.setOnClickListener { startActivity<DebounceActivity>() }
        btnLinkDistinct.setOnClickListener { startActivity<DistinctActivity>() }
        btnLinkDistinctUntilChanged.setOnClickListener { startActivity<DistinctUntilChangedActivity>() }
        btnLinkTakeUntil.setOnClickListener { startActivity<TakeUntilActivity>() }
        btnLinkDefaultEmpty.setOnClickListener { startActivity<DefaultIfEmptyActivity>() }
    }
}
