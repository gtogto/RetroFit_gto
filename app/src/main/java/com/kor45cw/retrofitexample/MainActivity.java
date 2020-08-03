package com.kor45cw.retrofitexample;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kor45cw.retrofitexample.Retrofit.ResponseBody.ResponseGet;
import com.kor45cw.retrofitexample.Retrofit.RetroCallback;
import com.kor45cw.retrofitexample.Retrofit.RetroClient;
import com.kor45cw.retrofitexample.databinding.ActivityMainBinding;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getSimpleName();
    private RetroClient retroClient;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setActivity(this);
        retroClient = RetroClient.getInstance(this).createBaseApi();
        binding.link.setMovementMethod(LinkMovementMethod.getInstance());

        getAppKeyHash();    // call a hashKey Function

    }

    private void setError(String errorString) {
        Log.e(LOG, errorString);
        binding.codeResult.setText(getString(R.string.error));
        binding.idResult.setText(getString(R.string.error));
        binding.titleResult.setText(getString(R.string.error));
        binding.useridResult.setText(getString(R.string.error));
        binding.bodyResult.setText(getString(R.string.error));
    }

    private void setFailure(int code) {
        binding.codeResult.setText(code);
        binding.idResult.setText(getString(R.string.failure));
        binding.titleResult.setText(getString(R.string.failure));
        binding.useridResult.setText(getString(R.string.failure));
        binding.bodyResult.setText(getString(R.string.failure));
    }


    public void get1(View view) {
        Toast.makeText(this, "GET 1 Clicked", Toast.LENGTH_SHORT).show();
        retroClient.getFirst("1", new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                setError(t.toString());
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                binding.codeResult.setText(String.valueOf(code));
                binding.idResult.setText(String.valueOf(data.id));
                binding.titleResult.setText(data.title);
                binding.useridResult.setText(String.valueOf(data.userId));
                binding.bodyResult.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                setFailure(code);
            }
        });
    }

    public void get2(View view) {
        Toast.makeText(this, "GET 2 Clicked", Toast.LENGTH_SHORT).show();
        //retroClient.getSecond("1", new RetroCallback() {
        retroClient.getSecond("2", new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                setError(t.toString());
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<ResponseGet> data = (List<ResponseGet>) receivedData;
                binding.codeResult.setText(String.valueOf(code));
                if (!data.isEmpty()) {
                    binding.idResult.setText(String.valueOf(data.get(0).id));
                    binding.titleResult.setText(data.get(0).title);
                    binding.useridResult.setText(String.valueOf(data.get(0).userId));
                    binding.bodyResult.setText(data.get(0).body);
                } else {
                    binding.idResult.setText(getString(R.string.empty));
                    binding.titleResult.setText(getString(R.string.empty));
                    binding.useridResult.setText(getString(R.string.empty));
                    binding.bodyResult.setText(getString(R.string.empty));
                }
            }

            @Override
            public void onFailure(int code) {
                setFailure(code);
            }
        });
    }

    public void post(View view) {
        Toast.makeText(this, "POST Clicked", Toast.LENGTH_SHORT).show();

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("title", "foo");
        parameters.put("body", "bar");
        parameters.put("userId", 1);

        retroClient.postFirst(parameters, new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                setError(t.toString());
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                binding.codeResult.setText(String.valueOf(code));
                binding.idResult.setText(String.valueOf(data.id));
                binding.titleResult.setText(data.title);
                binding.useridResult.setText(String.valueOf(data.userId));
                binding.bodyResult.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                setFailure(code);
            }
        });
    }

    public void put(View view) {
        Toast.makeText(this, "PUT Clicked", Toast.LENGTH_SHORT).show();

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("title", "foo");
        parameters.put("body", "bar");
        parameters.put("userId", 1);
        parameters.put("id", 1);

        retroClient.putFirst(parameters, new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                setError(t.toString());
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                binding.codeResult.setText(String.valueOf(code));
                binding.idResult.setText(String.valueOf(data.id));
                binding.titleResult.setText(data.title);
                binding.useridResult.setText(String.valueOf(data.userId));
                binding.bodyResult.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                setFailure(code);
            }
        });
    }

    public void patch(View view) {
        Toast.makeText(this, "PATCH Clicked", Toast.LENGTH_SHORT).show();

        retroClient.createBaseApi().patchFirst("foo", new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                setError(t.toString());
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                binding.codeResult.setText(String.valueOf(code));
                binding.idResult.setText(String.valueOf(data.id));
                binding.titleResult.setText(data.title);
                binding.useridResult.setText(String.valueOf(data.userId));
                binding.bodyResult.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                setFailure(code);
            }
        });
    }

    public void delete(View view) {
        Toast.makeText(this, "DELETE Clicked", Toast.LENGTH_SHORT).show();

        retroClient.deleteFirst(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                setError(t.toString());
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                binding.codeResult.setText(String.valueOf(code));
                binding.idResult.setText("");
                binding.titleResult.setText("");
                binding.useridResult.setText("");
                binding.bodyResult.setText("");
            }

            @Override
            public void onFailure(int code) {
                setFailure(code);
            }
        });
    }

    /* Create for HASH KEY value */
    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
    }

}
