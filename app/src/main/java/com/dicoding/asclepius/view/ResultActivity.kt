package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        imageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.resultImage.setImageURI(it)
        }

        val predictionResult = intent.getStringExtra(EXTRA_PREDICTION_RESULT)
        val predictionScore = intent.getStringExtra(EXTRA_PREDICTION_SCORE)

        binding.tvPrediction.text = predictionResult
        binding.tvConfidence.text = predictionScore
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_PREDICTION_RESULT = "extra_prediction_result"
        const val EXTRA_PREDICTION_SCORE = "extra_prediction_score"
    }
}