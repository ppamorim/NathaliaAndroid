package nathalia_android.ppamorim.github.com.minhalistinhabonitinha;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private CheckBox checkBox;
  private TextView textinho;
  private EditText campinho;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    checkBox = (CheckBox) findViewById(R.id.checkbox);
    textinho = (TextView) findViewById(R.id.textinho);
    campinho = (EditText) findViewById(R.id.campinho);
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    if (savedInstanceState != null) {
      campinho.setText(savedInstanceState.getString("texto_do_campinho"));
      checkBox.setChecked(savedInstanceState.getBoolean("checkBox_value"));
      textinho.setTextColor(savedInstanceState.getInt("cor_textinho"));
    }

    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if(checked) {
          textinho.setTextColor(Color.RED);
        } else {
          textinho.setTextColor(Color.BLACK);
        }
      }
    });
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    outState.putString("texto_do_campinho", campinho.getText().toString() );
    outState.putBoolean("checkBox_value", checkBox.isChecked());
    outState.putInt("cor_textinho", textinho.getCurrentTextColor());
    super.onSaveInstanceState(outState);
  }
}
