package com.android.study.lczv.customviewscoreboard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Placar : View {

    var viewWidth = 0
    var viewHeight = 0

    var firstTeamScore = 2
    var secondTeamScore = 2

    var firstTeamColor = Color.RED
    var secondTeamColor = Color.BLUE

    val paint = Paint()

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    fun init(attrs: AttributeSet?) {

        var attributeArray = context.obtainStyledAttributes(attrs, R.styleable.Placar)

        try {
            firstTeamScore = attributeArray.getInt(R.styleable.Placar_firstTeamScore, firstTeamScore)
            secondTeamScore = attributeArray.getInt(R.styleable.Placar_secondTeamScore, secondTeamScore)

            firstTeamColor = attributeArray.getColor(R.styleable.Placar_firstTeamColor, firstTeamColor)
            secondTeamColor = attributeArray.getColor(R.styleable.Placar_secondTeamColor, secondTeamColor)
        } finally {
            attributeArray.recycle()
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)

        setMeasuredDimension(viewWidth, viewHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        var x = viewWidth/2

        // Evita a divisão por zero
        if((firstTeamScore + secondTeamScore) > 0){
            x = (viewWidth * firstTeamScore) / (firstTeamScore + secondTeamScore)
        }

        // Desenha o score do segundo jogador
        paint.color = secondTeamColor
        canvas?.drawRect(0f, 0f, viewWidth.toFloat(), viewHeight.toFloat(), paint)

        // Desenha o score do primeiro jogador
        paint.color = firstTeamColor
        canvas?.drawRect(0f, 0f, x.toFloat(), viewHeight.toFloat(), paint)


    }


    fun update(score1:Int,score2:Int){

        firstTeamScore = score1
        secondTeamScore = score2

        invalidate()
    }

}