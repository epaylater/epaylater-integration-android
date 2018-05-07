# ePayLater Android redirect SDK

## How to use SDK

### Add this to your top level gradle file

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://dl.bintray.com/epaylater/maven" } // Add this to your top level gradle file
    }
}
```

### Added these dependencies to your app build.gradle file

```
dependencies {
    implementation 'com.android.support:appcompat-v7:27.1.1' //Required by SDK
    implementation 'in.epaylater.android:paymentsdk:0.0.5@aar'
}
```


### Initiate payment request

```

 EpayLaterParams paymentParams = new EpayLaterParams.Builder()
                        .setMcode("your mcode")
                        .setEncData("enc data from server")
                        .setPaymentUrl("payment url")
                        .setCheckSum("checksum for encdata")
                        .build();
 EpayLaterPaymentManager.startPayment(context, paymentParams);
                
```

### Listen for Payment response 

```

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

```