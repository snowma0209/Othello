package jp.codeforfun.othello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements SurrenderDialogFragment.NoticeDialogListener {

    ImageButton a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8,c1,c2,c3,c4,c5,c6,c7,c8,
                d1,d2,d3,d4,d5,d6,d7,d8,e1,e2,e3,e4,e5,e6,e7,e8,f1,f2,f3,f4,f5,f6,f7,f8,
                g1,g2,g3,g4,g5,g6,g7,g8,h1,h2,h3,h4,h5,h6,h7,h8;
    Button pass,surrender;
    ImageView color,win;
    String B = "Black";
    String W = "White";
    String N = "Null";
    String turn = B;
    String unturn =W;
    String state = "Playing";
    static String[][] disc = new String[8][8];
    int i = 0;
    int j = 0;
    int J = 0;
    int BlackCount = 0;
    int WhiteCount = 0;
    int turnCount = 0;
    TextView tv_CountBk;
    TextView tv_CountWt;
    TextView tv_Turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findViews();
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                disc[i][j] = N;

        disc[3][3] = W;
        disc[3][4] = B;
        disc[4][3] = B;
        disc[4][4] = W;
        setButton();
        Count();
        SetListener();
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        if(turn.equals(B)){
            color.setImageResource(R.drawable.color_english09_white);
            win.setVisibility(View.VISIBLE);
        }else if(turn.equals(W)){
            color.setImageResource(R.drawable.color_english11_black);
            win.setVisibility(View.VISIBLE);
        }
        state = "finished";
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(state.equals("finished")){
                    ResultDialogFragment dialogFragment = new ResultDialogFragment();
                    dialogFragment.show(getFragmentManager(),"ResultDialogFragment");
                }
        }
        return false;
    }

    public class DiscCheckListener implements View.OnClickListener{

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.a1:
                    i = 0;j = 0;
                    Set(a1);
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                if(i==0&&J==1)
                                Set(a2, 0, 1);
                                Set(a3, 0, 2);
                                Set(a4, 0, 3);
                                Set(a5, 0, 4);
                                Set(a6, 0, 5);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b2,1,1);
                                Set(c3,2,2);
                                Set(d4,3,3);
                                Set(e5,4,4);
                                Set(f6,5,5);
                                Set(g7,6,6);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                                Set(c1, 2, 0);
                                Set(d1, 3, 0);
                                Set(e1, 4, 0);
                                Set(f1, 5, 0);
                                Set(g1, 6, 0);
                            } else break;
                        }
                    }
                    break;
                case R.id.a2:
                    i = 0;j = 1;
                    Set(a2);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b3,1,2);
                                Set(c4,2,3);
                                Set(d5,3,4);
                                Set(e6,4,5);
                                Set(f7,5,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a3, 0, 2);
                                Set(a4, 0, 3);
                                Set(a5, 0, 4);
                                Set(a6, 0, 5);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                                Set(c2, 2, 1);
                                Set(d2, 3, 1);
                                Set(e2, 4, 1);
                                Set(f2, 5, 1);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.a3:
                    i = 0;j = 2;
                    Set(a3);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b4,1,3);
                                Set(c5,2,4);
                                Set(d6,3,5);
                                Set(e7,4,6);
                                Set(f7,5,7);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a4, 0, 3);
                                Set(a5, 0, 4);
                                Set(a6, 0, 5);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(b2, 1, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                                Set(c3, 2, 2);
                                Set(d3, 3, 2);
                                Set(e3, 4, 2);
                                Set(f3, 5, 2);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a2, 0, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.a4:
                    i = 0;j = 3;
                    Set(a4);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b5,1,4);
                                Set(c6,2,5);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a5, 0, 4);
                                Set(a6, 0, 5);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(b3, 1, 2);
                                Set(c2, 2, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b4, 1, 3);
                                Set(c4, 2, 3);
                                Set(d4, 3, 3);
                                Set(e4, 4, 3);
                                Set(f4, 5, 3);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a2, 0, 1);
                                Set(a3, 0, 2);
                            } else break;
                        }
                    }
                    break;
                case R.id.a5:
                    i = 0;j = 4;
                    Set(a5);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b6,1,5);
                                Set(c7,2,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a6, 0, 5);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(b4, 1, 3);
                                Set(c3, 2, 2);
                                Set(d2, 3, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b5, 1, 4);
                                Set(c5, 2, 4);
                                Set(d5, 3, 4);
                                Set(e5, 4, 4);
                                Set(f5, 5, 4);
                                Set(g5, 6, 4);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a2, 0, 1);
                                Set(a3, 0, 2);
                                Set(a4, 0, 3);
                            } else break;
                        }
                    }
                    break;
                case R.id.a6:
                    i = 0;j = 5;
                    Set(a6);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b7,1,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(b5, 1, 4);
                                Set(c4, 2, 3);
                                Set(d3, 3, 2);
                                Set(e2, 4, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                                Set(c6, 2, 5);
                                Set(d6, 3, 5);
                                Set(e6, 4, 5);
                                Set(f6, 5, 5);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a2, 0, 1);
                                Set(a3, 0, 2);
                                Set(a4, 0, 3);
                                Set(a5, 0, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.a7:
                    i = 0;j = 6;
                    Set(a7);
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(b6, 1, 5);
                                Set(c5, 2, 4);
                                Set(d4, 3, 3);
                                Set(e3, 4, 2);
                                Set(f2, 5, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                                Set(c7, 2, 6);
                                Set(d7, 3, 6);
                                Set(e7, 4, 6);
                                Set(f7, 5, 6);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        J = j;
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a2, 0, 1);
                                Set(a3, 0, 2);
                                Set(a4, 0, 3);
                                Set(a5, 0, 4);
                                Set(a6, 0, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.a8:
                    i = 0;j = 7;
                    Set(a8);
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(b7, 1, 6);
                                Set(c6, 2, 5);
                                Set(d5, 3, 4);
                                Set(e4, 4, 3);
                                Set(f3, 5, 2);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                                Set(c8, 2, 7);
                                Set(d8, 3, 7);
                                Set(e8, 4, 7);
                                Set(f8, 5, 7);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(a2, 0, 1);
                                Set(a3, 0, 2);
                                Set(a4, 0, 3);
                                Set(a5, 0, 4);
                                Set(a6, 0, 5);
                                Set(a7, 0, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.b1:
                    i = 1;j = 0;
                    Set(b1);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c2,2,1);
                                Set(d3,3,2);
                                Set(e4,4,3);
                                Set(f5,5,4);
                                Set(g6,6,5);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                                Set(b3, 1, 2);
                                Set(b4, 1, 3);
                                Set(b5, 1, 4);
                                Set(b6, 1, 5);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c1, 2, 0);
                                Set(d1, 3, 0);
                                Set(e1, 4, 0);
                                Set(f1, 5, 0);
                                Set(g1, 6, 0);
                            } else break;
                        }
                    }
                    break;
                case R.id.b2:
                    i = 1;j = 1;
                    Set(b2);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c3,2,2);
                                Set(d4,3,3);
                                Set(e5,4,4);
                                Set(f6,5,5);
                                Set(g7,6,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b3, 1, 2);
                                Set(b4, 1, 3);
                                Set(b5, 1, 4);
                                Set(b6, 1, 5);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c2, 2, 1);
                                Set(d2, 3, 1);
                                Set(e2, 4, 1);
                                Set(f2, 5, 1);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.b3:
                    i = 1;j = 2;
                    Set(b3);
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b4, 1, 3);
                                Set(b5, 1, 4);
                                Set(b6, 1, 5);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c4,2,3);
                                Set(d5,3,4);
                                Set(e6,4,5);
                                Set(f7,5,6);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c3, 2, 2);
                                Set(d3, 3, 2);
                                Set(e3, 4, 2);
                                Set(f3, 5, 2);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(c2, 2, 1);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                            } else break;
                        }
                    }
                        break;
                case R.id.b4:
                    i = 1;j = 3;
                    Set(b4);
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b5, 1, 4);
                                Set(b6, 1, 5);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c5,2,4);
                                Set(d6,3,5);
                                Set(e7,4,6);
                            }else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(c3, 2, 2);
                                Set(d2, 3, 1);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                                Set(b3, 1, 2);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c4, 2, 3);
                                Set(d4, 3, 3);
                                Set(e4, 4, 3);
                                Set(f4, 5, 3);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    break;
                case R.id.b5:
                    i = 1;j = 4;
                    Set(b5);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c6,2,5);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b6, 1, 5);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(c4, 2, 3);
                                Set(d3, 3, 2);
                                Set(e2, 4, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c5, 2, 4);
                                Set(d5, 3, 4);
                                Set(e5, 4, 4);
                                Set(f5, 5, 4);
                                Set(g5, 6, 4);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                                Set(b3, 1, 2);
                                Set(b4, 1, 3);
                            } else break;
                        }
                    }
                    break;
                case R.id.b6:
                    i = 1;j = 5;
                    Set(b6);
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c7,2,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(c5, 2, 4);
                                Set(d4, 3, 3);
                                Set(e3, 4, 2);
                                Set(f2, 5, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c6, 2, 5);
                                Set(d6, 3, 5);
                                Set(e6, 4, 5);
                                Set(f6, 5, 5);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                                Set(b3, 1, 2);
                                Set(b4, 1, 3);
                                Set(b5, 1, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.b7:
                    i = 1;j = 6;
                    Set(b7);
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(c6, 2, 5);
                                Set(d5, 3, 4);
                                Set(e4, 4, 3);
                                Set(f3, 5, 2);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c7, 2, 6);
                                Set(d7, 3, 6);
                                Set(e7, 4, 6);
                                Set(f7, 5, 6);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                                Set(b3, 1, 2);
                                Set(b4, 1, 3);
                                Set(b5, 1, 4);
                                Set(b6, 1, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.b8:
                    i = 1;j = 7;
                    Set(b8);
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(c7, 2, 6);
                                Set(d6, 3, 5);
                                Set(e5, 4, 4);
                                Set(f4, 5, 3);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c8, 2, 7);
                                Set(d8, 3, 7);
                                Set(e8, 4, 7);
                                Set(f8, 5, 7);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(b2, 1, 1);
                                Set(b3, 1, 2);
                                Set(b4, 1, 3);
                                Set(b5, 1, 4);
                                Set(b6, 1, 5);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.c1:
                    i = 2;j = 0;
                    Set(c1);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b2,1,1);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d2,3,1);
                                Set(e3,4,2);
                                Set(f4,5,3);
                                Set(g5,6,4);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                                Set(c3, 2, 2);
                                Set(c4, 2, 3);
                                Set(c5, 2, 4);
                                Set(c6, 2, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if ((checkRight(i, j))) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d1, 3, 0);
                                Set(e1, 4, 0);
                                Set(f1, 5, 0);
                                Set(g1, 6, 0);
                            } else break;
                        }
                    }
                    break;
                case R.id.c2:
                    i = 2;j = 1;
                    Set(c2);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(j==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b3,1,2);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d3,3,2);
                                Set(e4,4,3);
                                Set(f5,5,4);
                                Set(g6,6,5);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c3, 2, 2);
                                Set(c4, 2, 3);
                                Set(c5, 2, 4);
                                Set(c6, 2, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if ((checkRight(i, j))) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d2, 3, 2);
                                Set(e2, 4, 2);
                                Set(f2, 5, 2);
                                Set(g2, 6, 2);
                            } else break;
                        }
                    }
                    break;
                case R.id.c3:
                    i = 2;j = 2;
                    Set(c3);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b2, 1, 1);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b4,1,3);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c4, 2, 3);
                                Set(c5, 2, 4);
                                Set(c6, 2, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d4,3,3);
                                Set(e5,4,4);
                                Set(f6,5,5);
                                Set(g7,6,6);
                            }else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d2, 3, 1);
                            } else break;
                        }
                    }
                    if ((checkRight(i, j))) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d3, 3, 2);
                                Set(e3, 4, 2);
                                Set(f3, 5, 2);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.c4:
                    i = 2;j = 3;
                    Set(c4);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b3, 1, 2);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b4, 1, 3);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        int J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b5,1,4);
                            }else{
                                break;
                            }
                        }
                    }
                    if(checkRightDown(i,j)){
                        int J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d5,3,4);
                                Set(e6,4,5);
                                Set(f7,5,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c5, 2, 4);
                                Set(c6, 2, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d3, 4, 2);
                                Set(e2, 3, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d4, 3, 3);
                                Set(e4, 4, 3);
                                Set(f4, 5, 3);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                                Set(c3, 2, 2);
                            } else break;
                        }
                    }
                    break;
                case R.id.c5:
                    i = 2;j = 4;
                    Set(c5);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b4, 1, 3);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b5, 1, 4);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        for (int x = i-1; x > 0;x--){
                            j++;
                            if(j==7)break;
                            if (CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(b6,1,5);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c6, 2, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d6,3,5);
                                Set(e7,4,6);
                            }else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d4, 3, 3);
                                Set(e3, 4, 2);
                                Set(f2, 5, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(c5, 2, 4);
                                Set(d5, 3, 4);
                                Set(e5, 4, 4);
                                Set(f5, 5, 4);
                                Set(g5, 6, 4);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                                Set(c3, 2, 2);
                                Set(c4, 2, 3);
                            } else break;
                        }
                    }
                    break;
                case R.id.c6:
                    i = 2;j = 5;
                    Set(c6);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J== 0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b5, 1, 4);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(b7,1,6);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x, J)){
                                Reverse(x, J);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if (checkDown(i, j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d5, 3, 4);
                                Set(e4, 4, 3);
                                Set(f3, 5, 2);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d6, 3, 5);
                                Set(e6, 4, 5);
                                Set(f6, 5, 5);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                                Set(c3, 2, 2);
                                Set(c4, 2, 3);
                                Set(c5, 2, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.c7:
                    i = 2;j = 6;
                    Set(c7);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b6, 1, 5);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d6, 3, 5);
                                Set(e5, 4, 4);
                                Set(f4, 5, 3);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d7, 3, 6);
                                Set(e7, 4, 6);
                                Set(f7, 5, 6);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                                Set(c3, 2, 2);
                                Set(c4, 2, 3);
                                Set(c5, 2, 4);
                                Set(c6, 2, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.c8:
                    i = 2;j = 7;
                    Set(c8);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b7, 1, 6);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d7, 3, 6);
                                Set(e6, 4, 5);
                                Set(f5, 5, 4);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(d8, 3, 7);
                                Set(e8, 4, 7);
                                Set(f8, 5, 7);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(c2, 2, 1);
                                Set(c3, 2, 2);
                                Set(c4, 2, 3);
                                Set(c5, 2, 4);
                                Set(c6, 2, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.d1:
                    i=3;j=0;
                    Set(d1);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                                Set(c1, 2, 0);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c2,2,1);
                                Set(b3,1,2);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e2,4,1);
                                Set(f3,5,2);
                                Set(g4,6,3);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d2, 3, 1);
                                Set(d3, 3, 2);
                                Set(d4, 3, 3);
                                Set(d5, 3, 4);
                                Set(d6, 3, 5);
                                Set(d7, 3, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i,j)){
                        for (int x = i+1; x < 7; x++){
                            if(CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(e1,4,0);
                                Set(f1,5,0);
                                Set(g1,6,0);
                            }else break;
                        }
                    }
                    break;
                case R.id.d2:
                    i=3;j=1;
                    Set(d2);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                                Set(c2, 2, 1);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c3,2,2);
                                Set(b4,1,3);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e3,4,2);
                                Set(f4,5,3);
                                Set(g5,6,4);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d3, 3, 2);
                                Set(d4, 3, 3);
                                Set(d5, 3, 4);
                                Set(d6, 3, 5);
                                Set(d7, 3, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(e2, 4, 1);
                                Set(f2, 5, 1);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.d3:
                    i=3;j=2;
                    Set(d3);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (j==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(c2, 2, 1);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                                Set(c3, 2, 2);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c4,2,3);
                                Set(b5,1,4);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d4, 3, 3);
                                Set(d5, 3, 4);
                                Set(d6, 3, 5);
                                Set(d7, 3, 6);
                            } else if(disc[i][j].equals(N)) {
                                break;
                            }
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e4,4,3);
                                Set(f5,5,4);
                                Set(g6,6,5);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(e3, 4, 2);
                                Set(f3, 5, 2);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkRightUp(i, j)) {
                        J = j;
                        for (int x=i+1; x<7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(e2, 4, 1);
                            } else break;
                        }
                    }
                    if (checkUp(i, j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d2, 3, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.d6:
                    i=3;j=5;
                    Set(d6);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (j==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b4, 1, 3);
                                Set(c5, 2, 4);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                                Set(c6, 2, 5);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(j==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(c7,2,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d7, 3, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e7,4,6);
                            }else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J == 0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(e5, 4, 4);
                                Set(f4, 5, 3);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(e6, 4, 5);
                                Set(f6, 5, 5);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d2, 3, 1);
                                Set(d3, 3, 2);
                                Set(d4, 3, 3);
                                Set(d5, 3, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.d7:
                    i=3;j=6;
                    Set(d7);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b5, 1, 4);
                                Set(c6, 2, 5);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(e6, 4, 5);
                                Set(f5, 5, 4);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(e7, 4, 6);
                                Set(f7, 5, 6);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d2, 3, 1);
                                Set(d3, 3, 2);
                                Set(d4, 3, 3);
                                Set(d5, 3, 4);
                                Set(d6, 3, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.d8:
                    i=3;j=7;
                    Set(d8);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b6, 1, 5);
                                Set(c7, 2, 6);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                                Set(c8, 2, 7);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(e7, 4, 6);
                                Set(f6, 5, 5);
                                Set(g5, 6, 4);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(e8, 4, 7);
                                Set(f8, 5, 7);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(d2, 3, 1);
                                Set(d3, 3, 2);
                                Set(d4, 3, 3);
                                Set(d5, 3, 4);
                                Set(d6, 3, 5);
                                Set(d7, 3, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.e1:
                    i=4;j=0;
                    Set(e1);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                                Set(c1, 2, 0);
                                Set(d1, 3, 0);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(j==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d2,3,1);
                                Set(c3,2,2);
                                Set(b4,1,3);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f2,5,1);
                                Set(g3,6,2);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e2, 4, 1);
                                Set(e3, 4, 2);
                                Set(e4, 4, 3);
                                Set(e5, 4, 4);
                                Set(e6, 4, 5);
                                Set(e7, 4, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i,j)){
                        for (int x = i+1; x < 7; x++){
                            if(CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(f1,5,0);
                                Set(g1,6,0);
                            }else break;
                        }
                    }
                    break;
                case R.id.e2:
                    i=4;j=1;
                    Set(e2);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                                Set(c2, 2, 1);
                                Set(d2, 3, 1);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d3,3,2);
                                Set(c4,2,3);
                                Set(b5,1,4);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f3,5,2);
                                Set(g4,6,3);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e3, 4, 2);
                                Set(e4, 4, 3);
                                Set(e5, 4, 4);
                                Set(e6, 4, 5);
                                Set(e7, 4, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(f2, 5, 1);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.e3:
                    i=4;j=2;
                    Set(e3);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(d2, 3, 1);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                                Set(c3, 2, 2);
                                Set(d3, 3, 2);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d4,3,3);
                                Set(c5,2,4);
                                Set(b6,1,5);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f4,5,3);
                                Set(g5,6,4);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e4, 4, 3);
                                Set(e5, 4, 4);
                                Set(e6, 4, 5);
                                Set(e7, 4, 6);
                            } else if(disc[i][j].equals(N)) {
                                break;
                            }
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(f2, 5, 1);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(f3, 5, 2);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e2, 4, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.e6:
                    i=4;j=5;
                    Set(e6);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b3, 1, 2);
                                Set(c4, 2, 3);
                                Set(d5, 3, 4);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                                Set(c6, 2, 5);
                                Set(d6, 3, 5);
                            }
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(j==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f7,5,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e7, 4, 6);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(f5, 5, 4);
                                Set(g4, 5, 3);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(f6, 5, 5);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e5, 4, 4);
                                Set(e4, 4, 3);
                                Set(e3, 4, 2);
                                Set(e2, 4, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.e7:
                    i=4;j=6;
                    Set(e7);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b4, 1, 3);
                                Set(c5, 2, 4);
                                Set(d6, 3, 5);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                                Set(c7, 2, 6);
                                Set(d7, 3, 6);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(f6, 5, 5);
                                Set(g5, 4, 4);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(f7, 5, 6);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e2, 4, 1);
                                Set(e3, 4, 2);
                                Set(e4, 4, 3);
                                Set(e5, 4, 4);
                                Set(e6, 4, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.e8:
                    i=4;j=7;
                    Set(e8);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b5, 1, 4);
                                Set(c6, 2, 5);
                                Set(d7, 3, 6);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                                Set(c8, 2, 7);
                                Set(d8, 3, 7);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(f7, 5, 6);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(f8, 5, 7);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(e2, 4, 1);
                                Set(e3, 4, 2);
                                Set(e4, 4, 3);
                                Set(e5, 4, 4);
                                Set(e6, 4, 5);
                                Set(e7, 4, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.f1:
                    i=5;j=0;
                    Set(f1);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                                Set(c1, 2, 0);
                                Set(d1, 3, 0);
                                Set(e1, 4, 0);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e2,4,1);
                                Set(d3,3,2);
                                Set(c4,2,3);
                                Set(b5,1,4);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g2,6,1);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f2, 5, 1);
                                Set(f3, 5, 2);
                                Set(f4, 5, 3);
                                Set(f5, 5, 4);
                                Set(f6, 5, 5);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i,j)){
                        for (int x = i+1; x < 7; x++){
                            if(CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(g1,6,0);
                            }else break;
                        }
                    }
                    break;
                case R.id.f2:
                    i=5;j=1;
                    Set(f2);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                                Set(c2, 2, 1);
                                Set(d2, 3, 1);
                                Set(e2, 4, 1);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e3,4,2);
                                Set(d4,3,3);
                                Set(c5,2,4);
                                Set(b6,1,5);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g3,6,2);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f3, 5, 2);
                                Set(f4, 5, 3);
                                Set(f5, 5, 4);
                                Set(f6, 5, 5);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.f3:
                    i=5;j=2;
                    Set(f3);
                    if(checkLeftUp(i,j)) {
                        J = j;
                    for (int x=i-1; x > 0; x--) {
                        J--;
                        if (J==0) break;
                        if (CheckUnturn(x,J)) {
                            Reverse(x, j);
                            Set(e2, 4, 1);
                        }
                    }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                                Set(c3, 2, 2);
                                Set(d3, 3, 2);
                                Set(e3, 4, 2);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e4,4,3);
                                Set(d5,3,4);
                                Set(c6,2,5);
                                Set(b7,1,6);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g4,6,3);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        Log.d("f5checkdown","true");
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Log.d("f5checkunturn","true");
                                Reverse(i, J);
                                Set(f4, 5, 3);
                                Set(f5, 5, 4);
                                Set(f6, 5, 5);
                                Set(f7, 5, 6);
                            } else{
                                Log.d("f5false",disc[i][J]);
                                break;
                            }
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(g2, 6, 3);
                            } else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f2, 5, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.f4:
                    i=5;j=3;
                    Set(f4);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(d2, 3, 1);
                                Set(e3, 4, 2);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b4, 1, 3);
                                Set(c4, 2, 3);
                                Set(d4, 3, 3);
                                Set(e4, 4, 3);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e5,4,4);
                                Set(d6,3,5);
                                Set(c7,2,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f5, 5, 4);
                                Set(f6, 5, 5);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g5,6,4);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)) {
                        J = j;
                        for (int x = i+1; x < 7; x++) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(g3, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f2, 5, 1);
                                Set(f3, 5, 2);
                            } else break;
                        }
                    }
                    f4.setEnabled(false);
                    break;

                case R.id.f5:
                    i=5;j=4;
                    Set(f5);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(c2, 2, 1);
                                Set(d3, 3, 2);
                                Set(e4, 4, 3);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b5, 1, 4);
                                Set(c5, 2, 4);
                                Set(d5, 3, 4);
                                Set(e5, 4, 4);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(j==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e6,4,5);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)){
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                 Set(f6,5,5);
                                 Set(f7,5,6);
                             }else {
                                break;
                            }
                         }
                     }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g6,6,5);
                            }else break;
                        }
                    }
                    if (checkRight(i,j)){
                         for (int x = i+1; x < 7; x++){
                             if(CheckUnturn(x,j)){
                                 Reverse(x,j);
                                 Set(g5,6,4);
                             }else break;
                         }
                     }
                    if(checkRightUp(i,j)){
                         for (int x = i+1; x < 7; x++){
                             if (CheckUnturn(x,j)){
                                 Reverse(x,j);
                                 Set(g4,6,3);
                             }else break;
                         }
                     }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                 Set(f2, 5, 1);
                                 Set(f3, 5, 2);
                                 Set(f4, 5, 3);
                             } else break;
                         }
                     }
                    break;
                case R.id.f6:
                    i=5;j=5;
                    Set(f6);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b2, 1, 1);
                                Set(c3, 2, 2);
                                Set(d4, 3, 3);
                                Set(e5, 4, 4);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                                Set(c6, 2, 5);
                                Set(d6, 3, 5);
                                Set(e6, 4, 5);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        int J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(e7,4,6);
                            }else break;
                        }
                    }
                    if(checkRightDown(i,j)){
                        J = j;
                        for (int x = i+1; x < 7; x++){
                            J++;
                            if (J==7)break;
                            if(CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f6,5,5);
                                Set(g7,6,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f6, 5, 5);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)){
                        for (int x = i+1; x < 7; x++){
                            if (CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(g5,6,4);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f2, 5, 1);
                                Set(f3, 5, 2);
                                Set(f4, 5, 3);
                                Set(f5, 5, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.f7:
                    i=5;j=6;
                    Set(f7);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b3, 1, 2);
                                Set(c4, 2, 3);
                                Set(d5, 3, 4);
                                Set(e6, 4, 5);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                                Set(c7, 2, 6);
                                Set(d7, 3, 6);
                                Set(e7, 4, 6);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)){
                        for (int x = i+1; x < 7; x++){
                            if (CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(g6,6,5);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f2, 5, 1);
                                Set(f3, 5, 2);
                                Set(f4, 5, 3);
                                Set(f5, 5, 4);
                                Set(f6, 5, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.f8:
                    i=5;j=7;
                    Set(f8);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b4, 1, 3);
                                Set(c5, 2, 4);
                                Set(d6, 3, 5);
                                Set(e7, 4, 6);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                                Set(c8, 2, 7);
                                Set(d8, 3, 7);
                                Set(e8, 4, 7);
                            } else break;
                        }
                    }
                    if(checkRightUp(i,j)){
                        for (int x = i+1; x < 7; x++){
                            if (CheckUnturn(x,j)){
                                Reverse(x,j);
                                Set(g7,6,6);
                            }else break;
                        }
                    }
                    if (checkRight(i, j)) {
                        for (int x = i+1; x < 7; x++) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(f2, 5, 1);
                                Set(f3, 5, 2);
                                Set(f4, 5, 3);
                                Set(f5, 5, 4);
                                Set(f6, 5, 5);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.g1:
                    i=6;j=0;
                    Set(g1);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                                Set(c1, 2, 0);
                                Set(d1, 3, 0);
                                Set(e1, 4, 0);
                                Set(f1, 5, 0);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f2,5,1);
                                Set(e3,4,2);
                                Set(d4,3,3);
                                Set(c5,2,4);
                                Set(b6,1,5);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                                Set(g3, 6, 2);
                                Set(g4, 6, 3);
                                Set(g5, 6, 4);
                                Set(g6, 6, 5);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.g2:
                    i=6;j=1;
                    Set(g2);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                                Set(c2, 2, 1);
                                Set(d2, 3, 1);
                                Set(e2, 4, 1);
                                Set(f2, 5, 1);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f3,5,2);
                                Set(e4,4,3);
                                Set(d5,3,4);
                                Set(c6,2,5);
                                Set(b7,1,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g3, 6, 2);
                                Set(g4, 6, 3);
                                Set(g5, 6, 4);
                                Set(g6, 6, 5);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.g3:
                    i=6;j=2;
                    Set(g3);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(f2, 5, 1);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                                Set(c3, 2, 2);
                                Set(d3, 3, 2);
                                Set(e3, 4, 2);
                                Set(f3, 5, 2);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(j==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f4,5,3);
                                Set(e5,4,4);
                                Set(d6,3,5);
                                Set(c7,2,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g4, 6, 3);
                                Set(g5, 6, 4);
                                Set(g6, 6, 5);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.g4:
                    i=6;j=3;
                    Set(g4);
                    if(checkLeftUp(i,j)) {
                        J = j;
                    for (int x=i-1; x > 0; x--) {
                        J--;
                        if (J==0) break;
                        if (CheckUnturn(x,J)) {
                            Reverse(x, J);
                            Set(e2, 4, 1);
                            Set(f3, 5, 2);
                        }
                    }
                }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b4, 1, 3);
                                Set(c4, 2, 3);
                                Set(d4, 3, 3);
                                Set(e4, 4, 3);
                                Set(f4, 5, 3);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f5,5,4);
                                Set(e6,4,5);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g5, 6, 4);
                                Set(g6, 6, 5);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    break;

                case R.id.g5:
                    i=6;j=4;
                    Set(g5);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(d2, 3, 1);
                                Set(e3, 4, 2);
                                Set(f4, 5, 3);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b5, 1, 4);
                                Set(c5, 2, 4);
                                Set(d5, 3, 4);
                                Set(e5, 4, 4);
                                Set(f5, 5, 4);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f6,5,5);
                                Set(e7,4,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g6, 6, 5);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                                Set(g3, 6, 2);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    break;
                case R.id.g6:
                    i=6;j=5;
                    Set(g6);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(c2, 2, 1);
                                Set(d3, 3, 2);
                                Set(e4, 4, 3);
                                Set(f5, 5, 4);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                                Set(c6, 2, 5);
                                Set(d6, 3, 5);
                                Set(e6, 4, 5);
                                Set(f6, 5, 5);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(f7,5,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                                Set(g3, 6, 2);
                                Set(g4, 6, 3);
                                Set(g5, 6, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.g7:
                    i=6;j=6;
                    Set(g7);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b2, 1, 1);
                                Set(c3, 2, 2);
                                Set(d4, 3, 3);
                                Set(e5, 4, 4);
                                Set(f6, 5, 5);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                                Set(c7, 2, 6);
                                Set(d7, 3, 6);
                                Set(e7, 4, 6);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                                Set(g3, 6, 2);
                                Set(g4, 6, 3);
                                Set(g5, 6, 4);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.g8:
                    i=6;j=7;
                    Set(g8);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b3, 1, 2);
                                Set(c4, 2, 3);
                                Set(d5, 3, 4);
                                Set(e6, 4, 5);
                                Set(f7, 5, 6);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                                Set(c8, 2, 7);
                                Set(d8, 3, 7);
                                Set(e8, 4, 7);
                                Set(f8, 5, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(g2, 6, 1);
                                Set(g3, 6, 2);
                                Set(g4, 6, 3);
                                Set(g5, 6, 4);
                                Set(g6, 6, 5);
                                Set(g7, 6, 6);
                            }else break;
                        }
                    }
                    break;
                case R.id.h1:
                    i=7;j=0;
                    Set(h1);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b1, 1, 0);
                                Set(c1, 2, 0);
                                Set(d1, 3, 0);
                                Set(e1, 4, 0);
                                Set(f1, 5, 0);
                                Set(g1, 6, 0);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g2,6,1);
                                Set(f3,5,2);
                                Set(e4,4,3);
                                Set(d5,3,4);
                                Set(c6,2,5);
                                Set(b7,1,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                                Set(h3, 7, 2);
                                Set(h4, 7, 3);
                                Set(h5, 7, 4);
                                Set(h6, 7, 5);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.h2:
                    i=7;j=1;
                    Set(h2);
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b2, 1, 1);
                                Set(c2, 2, 1);
                                Set(d2, 3, 1);
                                Set(e2, 4, 1);
                                Set(f2, 5, 1);
                                Set(g2, 6, 1);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g3,6,2);
                                Set(f4,5,3);
                                Set(e5,4,4);
                                Set(d6,3,5);
                                Set(c7,2,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h3, 7, 2);
                                Set(h4, 7, 3);
                                Set(h5, 7, 4);
                                Set(h6, 7, 5);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    break;
                case R.id.h3:
                    i=7;j=2;
                    Set(h3);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(g2, 6, 1);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b3, 1, 2);
                                Set(c3, 2, 2);
                                Set(d3, 3, 2);
                                Set(e3, 4, 2);
                                Set(f3, 5, 2);
                                Set(g3, 6, 2);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g4,6,3);
                                Set(f5,5,4);
                                Set(e6,4,5);
                                Set(d7,3,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h4, 7, 3);
                                Set(h5, 7, 4);
                                Set(h6, 7, 5);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                            } else break;
                        }
                    }
                    break;
                case R.id.h4:
                    i=7;j=3;
                    Set(h4);
                    if(checkLeftUp(i,j)) {
                        J = j;
                    for (int x=i-1; x > 0; x--) {
                        J--;
                        if (J==0) break;
                        if (CheckUnturn(x, J)) {
                            Reverse(x, J);
                            Set(f2, 5, 1);
                            Set(g3, 6, 2);
                        }
                    }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b4, 1, 3);
                                Set(c4, 2, 3);
                                Set(d4, 3, 3);
                                Set(e4, 4, 3);
                                Set(f4, 5, 3);
                                Set(g4, 6, 3);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g5,6,4);
                                Set(f6,5,5);
                                Set(e7,4,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h5, 7, 4);
                                Set(h6, 7, 5);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                                Set(h3, 7, 2);
                            } else break;
                        }
                    }
                    break;
                case R.id.h5:
                    i=7;j=4;
                    Set(h5);
                    if(checkLeftUp(i,j)) {
                        J = j;
                    for (int x=i-1; x > 0; x--) {
                        J--;
                        if (J==0) break;
                        if (CheckUnturn(x,J)) {
                            Reverse(x, J);
                            Set(e2, 4, 1);
                            Set(f3, 5, 2);
                            Set(g4, 6, 3);
                        }
                    }
                }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b5, 1, 4);
                                Set(c5, 2, 4);
                                Set(d5, 3, 4);
                                Set(e5, 4, 4);
                                Set(f5, 5, 4);
                                Set(g5, 6, 4);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                        for (int x = i-1; x > 0;x--){
                            J++;
                            if(J==7)break;
                            if (CheckUnturn(x,J)){
                                Reverse(x,J);
                                Set(g6,6,5);
                                Set(f7,5,6);
                            }else break;
                        }
                    }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h6, 7, 5);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                                Set(h3, 7, 2);
                                Set(h4, 7, 3);
                            } else break;
                        }
                    }
                    break;
                case R.id.h6:
                    i=7;j=5;
                    Set(h6);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x, J)) {
                                Reverse(x, J);
                                Set(d2, 3, 1);
                                Set(e3, 4, 2);
                                Set(f4, 5, 3);
                                Set(g5, 6, 4);
                            }
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b6, 1, 5);
                                Set(c6, 2, 5);
                                Set(d6, 3, 5);
                                Set(e6, 4, 5);
                                Set(f6, 5, 5);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if(checkLeftDown(i,j)){
                        J = j;
                    for (int x = i-1; x > 0;x--){
                        J++;
                        if(J==7)break;
                        if (CheckUnturn(x,J)){
                            Reverse(x,J);
                            Set(g7,6,6);
                        }else break;
                    }
                }
                    if(checkDown(i,j)) {
                        for (int J = j+1; J < 7; J++) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                                Set(h3, 7, 2);
                                Set(h4, 7, 3);
                                Set(h5, 7, 4);
                            } else break;
                        }
                    }
                    break;
                case R.id.h7:
                    i=7;j=6;
                    Set(h7);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(c2, 2, 1);
                                Set(d3, 3, 2);
                                Set(e4, 4, 3);
                                Set(f5, 5, 4);
                                Set(g6, 6, 5);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b7, 1, 6);
                                Set(c7, 2, 6);
                                Set(d7, 3, 6);
                                Set(e7, 4, 6);
                                Set(f7, 5, 6);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                                Set(h3, 7, 2);
                                Set(h4, 7, 3);
                                Set(h5, 7, 4);
                                Set(h6, 7, 5);
                            } else break;
                        }
                    }
                    break;
                case R.id.h8:
                    i=7;j=7;
                    Set(h8);
                    if(checkLeftUp(i,j)) {
                        J = j;
                        for (int x=i-1; x > 0; x--) {
                            J--;
                            if (J==0) break;
                            if (CheckUnturn(x,J)) {
                                Reverse(x, J);
                                Set(b2, 1, 1);
                                Set(c3, 2, 2);
                                Set(d4, 3, 3);
                                Set(e5, 4, 4);
                                Set(f6, 5, 5);
                                Set(g7, 6, 6);
                            } else break;
                        }
                    }
                    if(checkLeft(i,j)) {
                        for (int x = i-1; x > 0; x--) {
                            if (CheckUnturn(x, j)) {
                                Reverse(x, j);
                                Set(b8, 1, 7);
                                Set(c8, 2, 7);
                                Set(d8, 3, 7);
                                Set(e8, 4, 7);
                                Set(f8, 5, 7);
                                Set(g8, 6, 7);
                            } else break;
                        }
                    }
                    if (checkUp(i,j)) {
                        for (int J = j-1; J > 0; J--) {
                            if (CheckUnturn(i, J)) {
                                Reverse(i, J);
                                Set(h2, 7, 1);
                                Set(h3, 7, 2);
                                Set(h4, 7, 3);
                                Set(h5, 7, 4);
                                Set(h6, 7, 5);
                                Set(h7, 7, 6);
                            } else break;
                        }
                    }
                    break;
            }
            Count();
            ChangeTurn();
        }
    }

    private class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bt_Pass:
                    if(CheckPassButton()) {
                        Count();
                        ChangeTurn();
                    }
                    break;
                case R.id.bt_Surrender:
                    SurrenderDialogFragment dialogFragment = new SurrenderDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"SurrenderDialogFragment");
            }
        }
    }

    private boolean setPlace(int i, int j){
        if(disc[i][j].equals(N)){
            if(i > 0 && j > 0)
                if(disc[i-1][j-1].equals(unturn))
                    if(checkLeftUp(i, j))
                        return true;

            if(i > 0)
                if(disc[i-1][j].equals(unturn))
                    if(checkLeft(i, j))
                        return true;

            if(i < 7)
                if(disc[i+1][j].equals(unturn))
                    if(checkRight(i, j))
                        return true;


            if(j > 0)
                if(disc[i][j-1].equals(unturn))
                    if(checkUp(i, j))
                        return true;

            if(j < 7)
                if(disc[i][j+1].equals(unturn))
                    if(checkDown(i, j))
                        return true;

            if(i > 0 && j < 7)
                if(disc[i-1][j+1].equals(unturn))
                    if(checkLeftDown(i, j))
                        return true;

            if(i < 7 && j > 0)
                if(disc[i+1][j-1].equals(unturn))
                    if(checkRightUp(i, j))
                        return true;

            if(i < 7 && j < 7)
                if (disc[i + 1][j + 1].equals(unturn))
                    return checkRightDown(i, j);

        }
        return  false;
    }

    public boolean checkLeftUp(int i,int j){

            for (int x = i-1; 0 <= x; x--) {
                j--;
                if(j < 0)break;
                    if(disc[x][j].equals(N)){
                        return false;
                    }else if(disc[x][j].equals(turn)) {
                        return true;
                    }
            }
            return false;

    }

    public boolean checkUp(int i,int j){

        for(int J = j-1; 0 <= J; J--){
            if(disc[i][J].equals(N)){
                return false;
            }else if(disc[i][J].equals(turn)){
                return true;
            }
        }
        return false;
    }

    public boolean checkRightUp(int i,int j){
        for (int x = i+1; x <= 7; x++) {
            j--;
            if (j==-1)break;
            if(disc[x][j].equals(N)){
                return false;
            }else if(disc[x][j].equals(turn)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeft(int i,int j){
            for (int x = i-1; 0 <= x; x--) {
                if (disc[x][j].equals(N)) {
                    return false;
                } else if (disc[x][j].equals(turn)) {

                    return true;
                }
            }
            return false;
    }

    public boolean checkRight(int i,int j){
            for (int x = i+1; x <= 7; x++) {
                if (disc[x][j].equals(N)) {
                    return false;
                } else if (disc[x][j].equals(turn)) {
                    return true;
                }
            }
            return false;
    }

    public boolean checkLeftDown(int i,int j){
            for (int x = i-1; 0 <= x; x--) {
                j++;
                if (j==8)break;
                if (disc[x][j].equals(N)) {
                    return false;
                } else if (disc[x][j].equals(turn)) {
                    return true;
                }
            }
            return false;
        }

    public boolean checkDown(int i,int j){
        for (int J = j+1; J <= 7; J++){
            if (disc[i][J].equals(N)) {
                return false;
            } else if (disc[i][J].equals(turn)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRightDown(int i,int j){
            for (int x = i+1; x <= 7; x++) {
                j++;
                if(j==8)break;
                if (disc[x][j].equals(N)) {
                    return false;
                } else if (disc[x][j].equals(turn)) {
                    return true;
                }
            }
            return false;
    }

    public void Set(ImageButton button,int x,int j){
        if (disc[x][j].equals(turn))
        if(turn.equals(B)) {
            disc[x][j]=B;
            SetBlack(button);
        }else if(turn.equals(W)) {
            disc[x][j]=W;
            SetWhite(button);
        }
    }

    public void Set(ImageButton button){
        if(turn.equals(B)) {
            SetBlack(button);
            disc[i][j] = turn;
        }else if(turn.equals(W)) {
            SetWhite(button);
            disc[i][j] = turn;
        }
        Log.d("Set",disc[i][j]+" "+i+" "+j);
    }


    public void findViews(){
        a1 = findViewById(R.id.a1); b1 = findViewById(R.id.b1); c1 = findViewById(R.id.c1); d1 = findViewById(R.id.d1);
        e1 = findViewById(R.id.e1); f1 = findViewById(R.id.f1); g1 = findViewById(R.id.g1); h1 = findViewById(R.id.h1);
        a2 = findViewById(R.id.a2); b2 = findViewById(R.id.b2); c2 = findViewById(R.id.c2); d2 = findViewById(R.id.d2);
        e2 = findViewById(R.id.e2); f2 = findViewById(R.id.f2); g2 = findViewById(R.id.g2); h2 = findViewById(R.id.h2);
        a3 = findViewById(R.id.a3); b3 = findViewById(R.id.b3); c3 = findViewById(R.id.c3); d3 = findViewById(R.id.d3);
        e3 = findViewById(R.id.e3); f3 = findViewById(R.id.f3); g3 = findViewById(R.id.g3); h3 = findViewById(R.id.h3);
        a4 = findViewById(R.id.a4); b4 = findViewById(R.id.b4); c4 = findViewById(R.id.c4); d4 = findViewById(R.id.d4);
        e4 = findViewById(R.id.e4); f4 = findViewById(R.id.f4); g4 = findViewById(R.id.g4); h4 = findViewById(R.id.h4);
        a5 = findViewById(R.id.a5); b5 = findViewById(R.id.b5); c5 = findViewById(R.id.c5); d5 = findViewById(R.id.d5);
        e5 = findViewById(R.id.e5); f5 = findViewById(R.id.f5); g5 = findViewById(R.id.g5); h5 = findViewById(R.id.h5);
        a6 = findViewById(R.id.a6); b6 = findViewById(R.id.b6); c6 = findViewById(R.id.c6); d6 = findViewById(R.id.d6);
        e6 = findViewById(R.id.e6); f6 = findViewById(R.id.f6); g6 = findViewById(R.id.g6); h6 = findViewById(R.id.h6);
        a7 = findViewById(R.id.a7); b7 = findViewById(R.id.b7); c7 = findViewById(R.id.c7); d7 = findViewById(R.id.d7);
        e7 = findViewById(R.id.e7); f7 = findViewById(R.id.f7); g7 = findViewById(R.id.g7); h7 = findViewById(R.id.h7);
        a8 = findViewById(R.id.a8); b8 = findViewById(R.id.b8); c8 = findViewById(R.id.c8); d8 = findViewById(R.id.d8);
        e8 = findViewById(R.id.e8); f8 = findViewById(R.id.f8); g8 = findViewById(R.id.g8); h8 = findViewById(R.id.h8);
        tv_CountBk = findViewById(R.id.tv_bkcount); tv_CountWt = findViewById(R.id.tv_wtcount); tv_Turn = findViewById(R.id.tv_whichTrun);
        pass = findViewById(R.id.bt_Pass);surrender = findViewById(R.id.bt_Surrender);
        color = findViewById(R.id.Color);win = findViewById(R.id.win);
    }
    public void setButton(){
        a1.setEnabled(setPlace(0, 0));a2.setEnabled(setPlace( 0, 1));
        a3.setEnabled(setPlace(0, 2));a4.setEnabled(setPlace( 0, 3));
        a5.setEnabled(setPlace(0, 4));a6.setEnabled(setPlace(0, 5));
        a7.setEnabled(setPlace(0, 6));a8.setEnabled(setPlace(0, 7));
        b1.setEnabled(setPlace(1, 0));b2.setEnabled(setPlace(1, 1));
        b3.setEnabled(setPlace(1, 2));b4.setEnabled(setPlace(1, 3));
        b5.setEnabled(setPlace(1, 4));b6.setEnabled(setPlace(1, 5));
        b7.setEnabled(setPlace(1, 6));b8.setEnabled(setPlace(1, 7));
        c1.setEnabled(setPlace(2, 0));c2.setEnabled(setPlace(2, 1));
        c3.setEnabled(setPlace(2, 2));c4.setEnabled(setPlace(2, 3));
        c5.setEnabled(setPlace(2, 4));c6.setEnabled(setPlace(2, 5));
        c7.setEnabled(setPlace(2, 6));c8.setEnabled(setPlace(2, 7));
        d1.setEnabled(setPlace(3, 0));d2.setEnabled(setPlace(3, 1));
        d3.setEnabled(setPlace(3, 2));d4.setEnabled(setPlace(3, 3));
        d5.setEnabled(setPlace(3, 4));d6.setEnabled(setPlace(3, 5));
        d7.setEnabled(setPlace(3, 6));d8.setEnabled(setPlace(3, 7));
        e1.setEnabled(setPlace(4, 0));e2.setEnabled(setPlace(4, 1));
        e3.setEnabled(setPlace(4, 2));e4.setEnabled(setPlace(4, 3));
        e5.setEnabled(setPlace(4, 4));e6.setEnabled(setPlace(4, 5));
        e7.setEnabled(setPlace(4, 6));e8.setEnabled(setPlace(4, 7));
        f1.setEnabled(setPlace(5, 0));f2.setEnabled(setPlace(5, 1));
        f3.setEnabled(setPlace(5, 2));f4.setEnabled(setPlace(5, 3));
        f5.setEnabled(setPlace(5, 4));f6.setEnabled(setPlace(5, 5));
        f7.setEnabled(setPlace(5, 6));f8.setEnabled(setPlace(5, 7));
        g1.setEnabled(setPlace(6, 0));g2.setEnabled(setPlace(6, 1));
        g3.setEnabled(setPlace(6, 2));g4.setEnabled(setPlace(6, 3));
        g5.setEnabled(setPlace(6, 4));g6.setEnabled(setPlace(6, 5));
        g7.setEnabled(setPlace(6, 6));g8.setEnabled(setPlace(6, 7));
        h1.setEnabled(setPlace(7, 0));h2.setEnabled(setPlace(7, 1));
        h3.setEnabled(setPlace(7, 2));h4.setEnabled(setPlace(7, 3));
        h5.setEnabled(setPlace(7, 4));h6.setEnabled(setPlace(7, 5));
        h7.setEnabled(setPlace(7, 6));h8.setEnabled(setPlace(7, 7));
        pass.setEnabled(CheckPassButton());
    }
    public void SetListener(){
        DiscCheckListener discCheckListener = new DiscCheckListener();
        a1.setOnClickListener(discCheckListener);a2.setOnClickListener(discCheckListener);
        a3.setOnClickListener(discCheckListener);a4.setOnClickListener(discCheckListener);
        a5.setOnClickListener(discCheckListener);a6.setOnClickListener(discCheckListener);
        a7.setOnClickListener(discCheckListener);a8.setOnClickListener(discCheckListener);
        b1.setOnClickListener(discCheckListener);b2.setOnClickListener(discCheckListener);
        b3.setOnClickListener(discCheckListener);b4.setOnClickListener(discCheckListener);
        b5.setOnClickListener(discCheckListener);b6.setOnClickListener(discCheckListener);
        b7.setOnClickListener(discCheckListener);b8.setOnClickListener(discCheckListener);
        c1.setOnClickListener(discCheckListener);c2.setOnClickListener(discCheckListener);
        c3.setOnClickListener(discCheckListener);c4.setOnClickListener(discCheckListener);
        c5.setOnClickListener(discCheckListener);c6.setOnClickListener(discCheckListener);
        c7.setOnClickListener(discCheckListener);c8.setOnClickListener(discCheckListener);
        d1.setOnClickListener(discCheckListener);d2.setOnClickListener(discCheckListener);
        d3.setOnClickListener(discCheckListener);d4.setOnClickListener(discCheckListener);
        d5.setOnClickListener(discCheckListener);d6.setOnClickListener(discCheckListener);
        d7.setOnClickListener(discCheckListener);d8.setOnClickListener(discCheckListener);
        e1.setOnClickListener(discCheckListener);e2.setOnClickListener(discCheckListener);
        e3.setOnClickListener(discCheckListener);e4.setOnClickListener(discCheckListener);
        e5.setOnClickListener(discCheckListener);e6.setOnClickListener(discCheckListener);
        e7.setOnClickListener(discCheckListener);e8.setOnClickListener(discCheckListener);
        f1.setOnClickListener(discCheckListener);f2.setOnClickListener(discCheckListener);
        f3.setOnClickListener(discCheckListener);f4.setOnClickListener(discCheckListener);
        f5.setOnClickListener(discCheckListener);f6.setOnClickListener(discCheckListener);
        f7.setOnClickListener(discCheckListener);f8.setOnClickListener(discCheckListener);
        g1.setOnClickListener(discCheckListener);g2.setOnClickListener(discCheckListener);
        g3.setOnClickListener(discCheckListener);g4.setOnClickListener(discCheckListener);
        g5.setOnClickListener(discCheckListener);g6.setOnClickListener(discCheckListener);
        g7.setOnClickListener(discCheckListener);g8.setOnClickListener(discCheckListener);
        h1.setOnClickListener(discCheckListener);h2.setOnClickListener(discCheckListener);
        h3.setOnClickListener(discCheckListener);h4.setOnClickListener(discCheckListener);
        h5.setOnClickListener(discCheckListener);h6.setOnClickListener(discCheckListener);
        h7.setOnClickListener(discCheckListener);h8.setOnClickListener(discCheckListener);
        ButtonListener buttonListener = new ButtonListener();
        pass.setOnClickListener(buttonListener);surrender.setOnClickListener(buttonListener);
    }

    public void SetBlack(ImageButton imageButton){
        imageButton.setImageResource(R.drawable.game_reversi_black);
        imageButton.setClickable(false);
    }

    public void SetWhite(ImageButton imageButton){
        imageButton.setImageResource(R.drawable.game_reversi_white);
        imageButton.setClickable(false);
    }

    public void Count(){
        turnCount++;
        Log.d("turn",String.valueOf(turnCount));
        BlackCount=0;
        WhiteCount=0;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (disc[i][j].equals(B)){
                    BlackCount++;
                }else if(disc[i][j].equals(W)) {
                    WhiteCount++;
                }
            }
        }
        tv_CountBk.setText(String.valueOf(BlackCount));
        tv_CountWt.setText(String.valueOf(WhiteCount));
        if(BlackCount+WhiteCount == 64){
            if(BlackCount > WhiteCount){
                color.setImageResource(R.drawable.color_english11_black);
                win.setVisibility(View.VISIBLE);
            }else if(WhiteCount > BlackCount){
                color.setImageResource(R.drawable.color_english09_white);
                win.setVisibility(View.VISIBLE);
            }
                state = "finished";
        }
    }

    public void ChangeTurn(){
        if(turn.equals(B)){
            turn = W;
            unturn = B;
            tv_Turn.setText("白");
            setButton();
        }else if(turn.equals(W)){
            turn = B;
            unturn = W;
            tv_Turn.setText("黒");
            setButton();
        }
    }

    public boolean CheckUnturn(int x, int j){
        return disc[x][j].equals(unturn);
    }

    public void Reverse(int i, int j){
        disc[i][j] = turn;
        Log.d("reverse",disc[i][j]+" "+i+" "+j);
    }

    public boolean CheckPassButton(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(setPlace(i,j)){
                    return false;
                }
            }
        }
        return true;
    }
}
