package com.progen;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ProGen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_gen);
        Button btnAccion = (Button) findViewById(R.id.btnAccion);
        btnAccion.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		TextView txvAccion = (TextView) findViewById(R.id.txvAccion);
        		txvAccion.setText(obtenerItem());
        	}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    	
        getMenuInflater().inflate(R.menu.activity_pro_gen, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_settings:
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ProGen");
            builder.setMessage("ProGen: Procrastination Generator\nVersión: 0.1 Beta\n2012/10/08\nCreado por:PoorDevPoor Apps");
            builder.setPositiveButton("OK",null);
            builder.create();
            builder.show();               	 
        	break;
        case R.id.menu_salir: 
        	finish();
        }
        return true;
    }
    
    private String obtenerItem() {
    	//Accedemos al objeto 'Recursos' desde la Activity
    	Resources res = this.getResources();
    	String strings[] = res.getStringArray(R.array.acciones);
    	int accion = (int) Math.floor(Math.random() * strings.length - 1);
    	accion--;
    	if(accion >= 0 && accion < strings.length)
    		return strings[accion];
    	else
    		return obtenerItem();
    }
}
