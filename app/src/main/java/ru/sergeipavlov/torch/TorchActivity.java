package ru.sergeipavlov.torch;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TorchActivity extends AppCompatActivity {

    ImageView ivTorchOff;
    ImageView ivTorchOn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_torch);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.torch), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivTorchOn = findViewById(R.id.ivTorchOn);
        ivTorchOff = findViewById(R.id.ivTorchOff);

        ivTorchOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    torchOff();
                    ivTorchOn.setVisibility(View.INVISIBLE);
                    ivTorchOff.setVisibility(View.VISIBLE);
                } catch (CameraAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ivTorchOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    torchOn();
                    ivTorchOff.setVisibility(View.INVISIBLE);
                    ivTorchOn.setVisibility(View.VISIBLE);
                } catch (CameraAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void torchOn() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) this.getSystemService(Context.CAMERA_SERVICE);
        String cameraID = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraID, true);
    }

    private void torchOff() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) this.getSystemService(Context.CAMERA_SERVICE);
        String cameraID = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraID, false);
    }
}
