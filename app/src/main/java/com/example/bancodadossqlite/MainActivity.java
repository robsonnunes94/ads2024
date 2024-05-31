package com.example.bancodadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public TextView productTitle1;
    public TextView productPriceValue1;
    public TextView productQntValue1;
    public TextView productMarcaValue1;
    public TextView productRefValue1;
    public TextView productDesc1;
    public TextView productLeve1;


    public TextView productTitle2;
    public TextView productPriceValue2;
    public TextView productQntValue2;
    public TextView productMarcaValue2;
    public TextView productRefValue2;
    public TextView productDesc2;
    public TextView productLeve2;

    public TextView productTitle3;
    public TextView productPriceValue3;
    public TextView productQntValue3;
    public TextView productMarcaValue3;
    public TextView productRefValue3;
    public TextView productDesc3;
    public TextView productLeve3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Integer cont = 1;

        try{
            SQLiteDatabase bancoDados;
            bancoDados = openOrCreateDatabase("PRJADS", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS PROMOCAO "
                    +" (CODPROD INT, DESCRPROD VARCHAR, "
                    +" MARCA VARCHAR, "
                    +" REFERENCIA VARCHAR, "
                    +" QUANTIDADE FLOAT, "
                    +" LEVE VARCHAR, "
                    +" VALOR FLOAT, DESCONTO VARCHAR); ");

            bancoDados.execSQL("INSERT INTO PROMOCAO (CODPROD, DESCRPROD, MARCA, REFERENCIA, QUANTIDADE, LEVE, VALOR, DESCONTO) "
                            + "VALUES (1, 'Arroz', 'Vasconcelos', '001', 12, 'Leve 5 pague 4', 20, '10% de desconto')");
            bancoDados.execSQL("INSERT INTO PROMOCAO (CODPROD, DESCRPROD, MARCA, REFERENCIA, QUANTIDADE, LEVE, VALOR, DESCONTO) "
                    + "VALUES (2, 'Feijão', 'Vasconcelos', '002', 15, 'Leve 6 pague 5', 10, '5% de desconto')");
            bancoDados.execSQL("INSERT INTO PROMOCAO (CODPROD, DESCRPROD, MARCA, REFERENCIA, QUANTIDADE, LEVE, VALOR, DESCONTO) "
                    + "VALUES (3, 'Detergente', 'Ypê', '405', 100, 'Leve 10 pague 9', 1.99, '20% de desconto')");
            Cursor cursor = bancoDados.rawQuery("SELECT CODPROD, DESCRPROD, MARCA, REFERENCIA, QUANTIDADE, LEVE, VALOR, DESCONTO FROM PROMOCAO WHERE CODPROD IN (1, 2, 3)", null);
            cursor.moveToFirst();

            while (cursor != null && cont <= 3) {


                if(cont == 2){

                    productPriceValue2 = (TextView) findViewById(R.id.productPriceValue2);
                    productTitle2 = (TextView) findViewById(R.id.productTitle2);
                    productQntValue2 = (TextView) findViewById(R.id.productQntValue2);
                    productMarcaValue2 = (TextView) findViewById(R.id.productMarcaValue2);
                    productRefValue2 = (TextView) findViewById(R.id.productRefValue2);
                    productDesc2 = (TextView) findViewById(R.id.productDesc2);
                    productLeve2 = (TextView) findViewById(R.id.productLeve2);

                    productDesc2.setText(cursor.getString((Integer) cursor.getColumnIndex("DESCONTO")));
                    productTitle2.setText(cursor.getString((Integer) cursor.getColumnIndex("DESCRPROD")));
                    productQntValue2.setText(cursor.getString((Integer) cursor.getColumnIndex("QUANTIDADE")));
                    productPriceValue2.setText(cursor.getString((Integer) cursor.getColumnIndex("VALOR")));
                    productMarcaValue2.setText(cursor.getString((Integer) cursor.getColumnIndex("MARCA")));
                    productLeve2.setText(cursor.getString((Integer) cursor.getColumnIndex("LEVE")));
                    productRefValue2.setText(cursor.getString((Integer) cursor.getColumnIndex("REFERENCIA")));

                }

                if(cont == 3){

                    productPriceValue3 = (TextView) findViewById(R.id.productPriceValue3);
                    productTitle3 = (TextView) findViewById(R.id.productTitle3);
                    productQntValue3 = (TextView) findViewById(R.id.productQntValue3);
                    productMarcaValue3 = (TextView) findViewById(R.id.productMarcaValue3);
                    productRefValue3 = (TextView) findViewById(R.id.productRefValue3);
                    productDesc3 = (TextView) findViewById(R.id.productDesc3);
                    productLeve3 = (TextView) findViewById(R.id.productLeve3);

                    productDesc3.setText(cursor.getString((Integer) cursor.getColumnIndex("DESCONTO")));
                    productTitle3.setText(cursor.getString((Integer) cursor.getColumnIndex("DESCRPROD")));
                    productQntValue3.setText(cursor.getString((Integer) cursor.getColumnIndex("QUANTIDADE")));
                    productPriceValue3.setText(cursor.getString((Integer) cursor.getColumnIndex("VALOR")));
                    productMarcaValue3.setText(cursor.getString((Integer) cursor.getColumnIndex("MARCA")));
                    productLeve3.setText(cursor.getString((Integer) cursor.getColumnIndex("LEVE")));
                    productRefValue3.setText(cursor.getString((Integer) cursor.getColumnIndex("REFERENCIA")));

                }

                if(cont == 1){

                    productPriceValue1 = (TextView) findViewById(R.id.productPriceValue1);
                    productTitle1 = (TextView) findViewById(R.id.productTitle1);
                    productQntValue1 = (TextView) findViewById(R.id.productQntValue1);
                    productMarcaValue1 = (TextView) findViewById(R.id.productMarcaValue1);
                    productRefValue1 = (TextView) findViewById(R.id.productRefValue1);
                    productDesc1 = (TextView) findViewById(R.id.productDesc1);
                    productLeve1 = (TextView) findViewById(R.id.productLeve1);

                    productDesc1.setText(cursor.getString((Integer) cursor.getColumnIndex("DESCONTO")));
                    productTitle1.setText(cursor.getString((Integer) cursor.getColumnIndex("DESCRPROD")));
                    productQntValue1.setText(cursor.getString((Integer) cursor.getColumnIndex("QUANTIDADE")));
                    productPriceValue1.setText(cursor.getString((Integer) cursor.getColumnIndex("VALOR")));
                    productMarcaValue1.setText(cursor.getString((Integer) cursor.getColumnIndex("MARCA")));
                    productLeve1.setText(cursor.getString((Integer) cursor.getColumnIndex("LEVE")));
                    productRefValue1.setText(cursor.getString((Integer) cursor.getColumnIndex("REFERENCIA")));

                }
                cursor.moveToNext();
                cont++;
            }
            bancoDados.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}