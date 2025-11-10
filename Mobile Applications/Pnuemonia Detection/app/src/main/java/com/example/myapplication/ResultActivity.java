package com.example.myapplication;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.tensorflow.lite.Interpreter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ResultActivity extends AppCompatActivity {

    private static final int IMAGE_SIZE = 128;
    private Interpreter tflite;
    private TextView resultTextView;
    private ImageView imageView;

    // 🔁 Replace with your actual class labels
    private final String[] labels = {"Normal", "Bacteria", "Virus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        imageView = findViewById(R.id.resultImageView);

        Bitmap bitmap = ImageClassifierHelper.bitmap;


        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            try {
                tflite = new Interpreter(loadModelFile("model.tflite")); // 👈 Use your actual model filename
                String result = classifyImage(bitmap);
                resultTextView.setText("Prediction: " + result);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error loading model", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No image received", Toast.LENGTH_SHORT).show();
        }
    }

    private MappedByteBuffer loadModelFile(String modelFileName) throws IOException {
        AssetFileDescriptor fileDescriptor = getAssets().openFd(modelFileName);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    private String classifyImage(Bitmap bitmap) {
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, IMAGE_SIZE, IMAGE_SIZE, true);
        ByteBuffer input = convertBitmapToByteBuffer(resized);

        float[][] output = new float[1][labels.length];
        tflite.run(input, output);

        int maxIdx = 0;
        float maxProb = 0;
        for (int i = 0; i < output[0].length; i++) {
            if (output[0][i] > maxProb) {
                maxProb = output[0][i];
                maxIdx = i;
            }
        }

        return labels[maxIdx] + " (" + String.format("%.2f", maxProb * 100) + "%)";
    }

    private ByteBuffer convertBitmapToByteBuffer(Bitmap bitmap) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(4 * IMAGE_SIZE * IMAGE_SIZE * 3);
        buffer.order(ByteOrder.nativeOrder());

        int[] intValues = new int[IMAGE_SIZE * IMAGE_SIZE];
        bitmap.getPixels(intValues, 0, IMAGE_SIZE, 0, 0, IMAGE_SIZE, IMAGE_SIZE);

        for (int pixel : intValues) {
            buffer.putFloat(((pixel >> 16) & 0xFF) / 255.0f); // R
            buffer.putFloat(((pixel >> 8) & 0xFF) / 255.0f);  // G
            buffer.putFloat((pixel & 0xFF) / 255.0f);         // B
        }

        return buffer;
    }
}
