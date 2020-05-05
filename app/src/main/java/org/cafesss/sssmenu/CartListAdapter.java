package org.cafesss.sssmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.AlertDialogLayout;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CartListAdapter extends BaseAdapter{
    private Context context;
    private List<Cart> cartList;

    CartDBHelper cartDB;
    PaymentDBHelper paymentDB;
    public CartListAdapter(Context context, List<Cart> cartList) {
        super();
        this.context = context;
        this.cartList = cartList;
    }

    public int getCount() {
        return cartList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return cartList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final Context context = parent.getContext();
        cartDB = new CartDBHelper(context);
        paymentDB=new PaymentDBHelper(context);
        View v = View.inflate(context, R.layout.cart_list_item, null);
        final TextView name = (TextView) v.findViewById(R.id.name);
        final TextView numtxt = (TextView) v.findViewById(R.id.numtxt);

        final ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

        Button buttono = (Button) v.findViewById(R.id.buttono);
        Button buttond = (Button) v.findViewById(R.id.buttond);
        Button buttonm = (Button) v.findViewById(R.id.buttonm);
        Button buttonp = (Button) v.findViewById(R.id.buttonp);

       Button changeButton = (Button) v.findViewById(R.id.changeButton);
        CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox);

        final String id=cartList.get(position).getId();
        final String product = cartList.get(position).getProduct();

        String size = cartDB.findSize(id,product);
        int price = cartDB.findPrice(id,product);
        int prodnum = cartDB.findProdNum(id,product);
        int totalprice = cartDB.findTotalPrice(id,product);
        imageView.setImageResource(cartList.get(position).getPic());

        numtxt.setText(String.format("%d", prodnum));
        name.setText(String.format("%s\nsize:%s, 개수:%d개\n%d원  /  총 %d원", product, size, prodnum, price, totalprice));

        buttonm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String product = cartList.get(position).getProduct();
                int prodnum = cartDB.findProdNum(id,product);
                int price = cartList.get(position).getPrice();
                int totalprice = cartDB.findTotalPrice(id,product);
                String size = cartDB.findSize(id,product);
                if (prodnum > 1) {
                    prodnum--;
                    totalprice -= price;
                    cartList.get(position).setProdnum(prodnum);
                    cartList.get(position).setTotalprice(totalprice);
                    cartDB.UpDate(id,product, prodnum, totalprice);

                    notifyDataSetChanged();

                }
            }
        });

        buttonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String product = cartList.get(position).getProduct();
                int prodnum = cartDB.findProdNum(id,product);
                int price = cartDB.findPrice(id,product);
                int totalprice = cartDB.findTotalPrice(id,product);
                String size = cartDB.findSize(id,product);
                prodnum++;
                totalprice += price;
                cartList.get(position).setProdnum(prodnum);
                cartList.get(position).setTotalprice(totalprice);
                cartDB.UpDate(id,product, prodnum, totalprice);
                notifyDataSetChanged();

            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (product.equals("AlmondCroissant") || product.equals("BlueberryBagel")
                        || product.equals("CheeseDanish") || product.equals("LeafPie") ||
                        product.equals("ChocolateMuffin") || product.equals("ClassicScone")) {
                    Toast.makeText(context, "베이커리 종류는 사이즈 구분이 없습니다 ", Toast.LENGTH_SHORT).show();
                } else {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.notifprice);

                    Button largeButton = (Button) dialog.findViewById(R.id.largeButton);
                    Button mediumButton = (Button) dialog.findViewById(R.id.mediumButton);
                    Button smallButton = (Button) dialog.findViewById(R.id.smallButton);

                    largeButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            String before = cartDB.findSize(id,product);
                            int beforePrice = cartDB.findPrice(id,product);
                            switch (before) {
                                case "small":
                                    cartDB.UpDatePrice(id,product, beforePrice + 1000);
                                    break;
                                case "medium":
                                    cartDB.UpDatePrice(id,product, (beforePrice + 500));
                                    break;
                                case "large":
                                    cartDB.UpDatePrice(id,product, (beforePrice));
                                    break;
                            }
                            cartDB.UpDateTotalPrice(id,product, (cartDB.findPrice(id,product) * cartDB.findProdNum(id,product)));
                            cartDB.inputSize(id,product, "large");

                            notifyDataSetChanged();

                            dialog.dismiss();
                            Toast.makeText(context, "변경되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    });

                    mediumButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            String before = cartDB.findSize(id,product);
                            int beforePrice = cartDB.findPrice(id,product);
                            switch (before) {
                                case "small":
                                    cartDB.UpDatePrice(id,product, (beforePrice + 500));
                                    break;
                                case "medium":
                                    cartDB.UpDatePrice(id,product, (beforePrice));
                                    break;
                                case "large":
                                    cartDB.UpDatePrice(id,product, (beforePrice - 500));
                                    break;
                            }
                            cartDB.UpDateTotalPrice(id,product, (cartDB.findPrice(id,product) * cartDB.findProdNum(id,product)));
                            cartDB.inputSize(id,product, "medium");

                            notifyDataSetChanged();

                            dialog.dismiss();
                            Toast.makeText(context, "변경되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    });

                    smallButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            String before = cartDB.findSize(id,product);
                            int beforePrice = cartDB.findPrice(id,product);
                            switch (before) {
                                case "small":
                                    cartDB.UpDatePrice(id,product, beforePrice);
                                    break;
                                case "medium":
                                    cartDB.UpDatePrice(id,product, (beforePrice - 500));
                                    break;
                                case "large":
                                    cartDB.UpDatePrice(id,product, (beforePrice - 1000));
                                    break;
                            }
                            cartDB.UpDateTotalPrice(id,product, (cartDB.findPrice(id,product) * cartDB.findProdNum(id,product)));
                            cartDB.inputSize(id,product, "small");

                            notifyDataSetChanged();

                            dialog.dismiss();
                            Toast.makeText(context, "변경되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.show();
                }
            }
        });

        checkBox.setOnCheckedChangeListener((buttonView, isChecked)->{
            if(isChecked){
                cartDB.UpDateSel(id,product,"s");
            }else{
                cartDB.UpDateSel(id,product,"n");
            }
        });


        buttono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PaymentActivity.class);
                intent.putExtra("whichButton","o");
                intent.putExtra("id", id);
                intent.putExtra("payproduct",product);
                paymentDB.delete(id);
                context.startActivity(intent);
            }
        });

        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartDB.deleteID(id,product);
                Intent intent = new Intent(context,WaitActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });


        return v;
    }
}

