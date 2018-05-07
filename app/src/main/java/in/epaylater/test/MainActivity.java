package in.epaylater.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.epaylater.android.EpayLaterParams;
import in.epaylater.android.EpayLaterPaymentManager;
import in.epaylater.android.PaymentResponse;

public class MainActivity extends AppCompatActivity {

    EditText encData, mCode, checkSum, paymentUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton = findViewById(R.id.click_button);

        encData = findViewById(R.id.txt_encdata);
        mCode = findViewById(R.id.txt_mcode);
        checkSum = findViewById(R.id.txt_checksum);
        paymentUrl = findViewById(R.id.txt_payment_url);

        final String paymentUrl = "https://payment-sandbox-2.epaylater.in/web/process-transaction";
        final String checksum = "E2AD4B5148F3EF9FDAFFE1DED01E8A5B1ED74BEFAD7818C7DAEE14B79A1ED93C";
        final String encdata = "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";
        final String mCode = "TEST";

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EpayLaterParams paymentParams = new EpayLaterParams.Builder()
                        .setMcode(MainActivity.this.mCode.getText().toString().isEmpty() ? mCode : MainActivity.this.mCode.getText().toString())
                        .setEncData(MainActivity.this.encData.getText().toString().isEmpty() ? encdata : MainActivity.this.encData.getText().toString())
                        .setPaymentUrl(MainActivity.this.paymentUrl.getText().toString().isEmpty() ? paymentUrl : MainActivity.this.paymentUrl.getText().toString())
                        .setCheckSum(MainActivity.this.checkSum.getText().toString().isEmpty() ? checksum : MainActivity.this.checkSum.getText().toString())
                        .build();
                EpayLaterPaymentManager.startPayment(MainActivity.this, paymentParams);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EpayLaterPaymentManager.PAYMENT_REQUEST && resultCode == RESULT_OK && data != null) {
            PaymentResponse paymentResponse = data.getParcelableExtra(EpayLaterPaymentManager.PAYMENT_RESPONSE);
            if (paymentResponse != null) {
                if (paymentResponse.getStatus() == PaymentResponse.Status.SUCCESS) {
                    //Handle Payment Success
                    Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();
                } else if (paymentResponse.getStatus() == PaymentResponse.Status.FAILURE) {
                    //Handle Payment Failure
                    Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
                }
            }
        }

        if (requestCode == EpayLaterPaymentManager.PAYMENT_REQUEST && resultCode == RESULT_CANCELED && data != null) {
            PaymentResponse paymentResponse = data.getParcelableExtra(EpayLaterPaymentManager.PAYMENT_RESPONSE);
            if (paymentResponse != null) {
                if (paymentResponse.getStatus() == PaymentResponse.Status.INVALID_INPUTS) {
                    Toast.makeText(this, paymentResponse.getMessage(), Toast.LENGTH_SHORT).show();
                } else if (paymentResponse.getStatus() == PaymentResponse.Status.ABNORMAL_EXIT) {
                    Toast.makeText(this, paymentResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
