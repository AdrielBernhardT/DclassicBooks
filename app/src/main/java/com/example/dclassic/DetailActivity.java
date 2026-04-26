package com.example.dclassic;

public class DetailActivity extends AppCompatActivity {

    EditText etAddress, etPhone;
    Button btnPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        btnPurchase = findViewById(R.id.btnPurchase);

        btnPurchase.setOnClickListener(v -> {
            String address = etAddress.getText().toString();
            String phone = etPhone.getText().toString();

            if(address.isEmpty() || phone.isEmpty()){
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            } else if(!phone.matches("[0-9]+")){
                Toast.makeText(this, "Phone must be numeric", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Purchase success!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}