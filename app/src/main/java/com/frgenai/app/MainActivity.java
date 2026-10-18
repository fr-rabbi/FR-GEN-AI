
package com.frgenai.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout chat;
    EditText input;
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 20, 20, 20);
        root.setBackgroundColor(Color.rgb(15, 17, 25));

        TextView title = new TextView(this);
        title.setText("F R GEN AI");
        title.setTextColor(Color.WHITE);
        title.setTextSize(26);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView status = new TextView(this);
        status.setText("Offline AI • Prototype");
        status.setTextColor(Color.LTGRAY);
        status.setGravity(Gravity.CENTER);
        root.addView(status);

        scroll = new ScrollView(this);
        chat = new LinearLayout(this);
        chat.setOrientation(LinearLayout.VERTICAL);
        chat.setPadding(0, 20, 0, 20);
        scroll.addView(chat);

        root.addView(scroll, new LinearLayout.LayoutParams(
            -1, 0, 1
        ));

        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);

        input = new EditText(this);
        input.setHint("Message লিখো...");
        input.setTextColor(Color.WHITE);
        input.setHintTextColor(Color.GRAY);
        bar.addView(input, new LinearLayout.LayoutParams(
            0, -2, 1
        ));

        Button send = new Button(this);
        send.setText("Send");
        bar.addView(send);

        root.addView(bar);
        setContentView(root);

        addMessage("F R GEN AI", "স্বাগতম! আমি তোমার AI অ্যাপের প্রোটোটাইপ।");

        send.setOnClickListener(v -> {
            String message = input.getText().toString().trim();

            if (message.isEmpty()) return;

            addMessage("You", message);
            input.setText("");

            addMessage("F R GEN AI",
                "এখনো AI model যুক্ত হয়নি। পরের ধাপে offline model যুক্ত করব।");
        });
    }

    void addMessage(String sender, String message) {
        TextView bubble = new TextView(this);
        bubble.setText(sender + "\n" + message);
        bubble.setTextColor(Color.WHITE);
        bubble.setTextSize(16);
        bubble.setPadding(16, 12, 16, 12);
        bubble.setBackgroundColor(Color.rgb(39, 43, 58));

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(-1, -2);
        params.setMargins(0, 8, 0, 8);

        chat.addView(bubble, params);
        scroll.post(() -> scroll.fullScroll(ScrollView.FOCUS_DOWN));
    }
          }
