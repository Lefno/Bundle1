package curso.postal.bundle1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class LoginOK extends Activity {

	private TextView txt_login;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_ok);
		
		
		txt_login = (TextView) findViewById(R.id.txt_login);
		
		String [] users = getResources().getStringArray(R.array.array_login_user);
		String [] pass = getResources().getStringArray(R.array.array_login_pass);
		
		Bundle datosLogin = getIntent().getExtras();
		
		for(int i = 0;i >= users.length;i++)
			if (users[i].equals(datosLogin.get(getResources().getString(R.string.user))))
			{
					if(pass[i].equalsIgnoreCase(datosLogin.getString(getResources().getString(R.string.password))))
						{
							txt_login.setText(R.string.correcto);
						}	
			}
			else
			{
				txt_login.setText(R.string.incorrecto);
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login_ok, menu);
		return true;
	}

}
