package curso.postal.bundle1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn;
	private EditText edt_user;
	private EditText edt_pass;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.btn_enviar);
		edt_user =(EditText) findViewById(R.id.edit_user);
		edt_pass = (EditText) findViewById(R.id.edit_pass);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(edt_pass.getText().toString().equals("") || edt_user.getText().toString().equals(""))
				{
					Toast.makeText(MainActivity.this, R.string.error_datos, Toast.LENGTH_LONG).show();
				}
				else
				{
					Intent envioDatos = new Intent();
					Bundle datosLogin = new Bundle();
					
					datosLogin.putString(getResources().getString(R.string.user), edt_user.getText().toString());
					datosLogin.putString(getResources().getString(R.string.password), edt_pass.getText().toString());
					
					envioDatos.setClass(MainActivity.this, LoginOK.class);
					envioDatos.putExtras(datosLogin);
					
					startActivity(envioDatos);
					
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
