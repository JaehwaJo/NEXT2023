package toss.next.woghk2233;

import android.content.Intent;
import android.os.Bundle;
import toss.next.woghk2233.Menu;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuListActivity extends AppCompatActivity {

    private List<Menu> menuList; // 전체 메뉴 리스트 데이터
    private RecyclerView menuRecyclerView;
    private MenuListAdapter menuListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        // 전체 메뉴 리스트를 가져오는 로직이 있다고 가정하고 데이터를 초기화합니다.
        menuList = getMenuList();

        menuRecyclerView = findViewById(R.id.menuRecyclerView);
        menuListAdapter = new MenuListAdapter(this, menuList);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuRecyclerView.setAdapter(menuListAdapter);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이전 화면(IntroActivity)으로 이동
                startActivity(new Intent(MenuListActivity.this, MainActivity.class));
                //finish();
            }
        });
    }

    private List<Menu> getMenuList() {
        // 전체 메뉴 리스트 데이터를 가져오는 로직을 구현합니다.
        // 예시로 미리 정의된 메뉴 정보를 사용합니다.
        List<Menu> menuList = new ArrayList<>();

        // 메뉴 정보를 추가합니다.
        menuList.add(new Menu("아메리카노", "Coffee", true, true, 1000));
        menuList.add(new Menu("카페라떼", "Coffee", true, true, 1500));
        menuList.add(new Menu("카푸치노", "Coffee", true, true, 2000));
        menuList.add(new Menu("오렌지에이드", "Beverage", true, false, 2500));
        menuList.add(new Menu("망고에이드", "Beverage", true, false, 2500));
        menuList.add(new Menu("얼그레이티", "Tea", false, true, 1000));
        menuList.add(new Menu("루이보스티", "Tea", false, true, 2000));
        menuList.add(new Menu("치즈케이크", "Dessert", false, false, 3000));
        menuList.add(new Menu("마들렌", "Dessert", false, false, 1000));
        menuList.add(new Menu("휘낭시에", "Dessert", false, false, 1500));

        return menuList;
    }
}