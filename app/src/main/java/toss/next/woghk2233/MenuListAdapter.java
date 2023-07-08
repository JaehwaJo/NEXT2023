package toss.next.woghk2233;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder> {

    private Context context;
    private List<Menu> menuList;

    public MenuListAdapter(Context context, List<Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    public int getItemViewType(int position) {
        // 현재 아이템의 카테고리와 이전 아이템의 카테고리를 비교하여 헤더인지 메뉴인지 판별합니다.
        if (position == 0 || !menuList.get(position).getCategory().equals(menuList.get(position - 1).getCategory())) {
            // 첫 번째 아이템이거나 현재 아이템의 카테고리가 이전 아이템의 카테고리와 다른 경우는 헤더로 처리합니다.
            return 0; // 헤더 타입
        } else {
            // 현재 아이템의 카테고리가 이전 아이템의 카테고리와 동일한 경우는 메뉴로 처리합니다.
            return 1; // 메뉴 타입
        }
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (viewType == 0) {
            // 헤더 아이템 뷰
            View headerView = inflater.inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(headerView);
        } else {
            // 메뉴 아이템 뷰
            View menuView = inflater.inflate(R.layout.item_menu, parent, false);
            return new MenuViewHolder(menuView);
        }
    }
    public class HeaderViewHolder extends MenuViewHolder {
        TextView categoryTextView;
        TextView menuNameTextView;
        TextView menuPriceTextView;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            menuNameTextView = itemView.findViewById(R.id.menuNameTextView);
            menuPriceTextView = itemView.findViewById(R.id.menuPriceTextView);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = menuList.get(position);

        if (holder instanceof HeaderViewHolder) {
            // 헤더 뷰 홀더인 경우
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.categoryTextView.setText(menu.getCategory());
            headerViewHolder.menuNameTextView.setText(menu.getName());
            headerViewHolder.menuPriceTextView.setText(menu.getPrice() + "원");
        } else {
            holder.bind(menu);
            // 메뉴 뷰 홀더인 경우
            // 기존의 onBindViewHolder() 내용을 추가로 작성합니다.
            // ...
        }

        // 기타 메뉴 정보를 설정하는 로직을 추가합니다.
        // 예: HOT/ICE 선택 가능 여부, 디카페인 선택 가능 여부 등을 설정합니다.

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 메뉴 상세 화면으로 이동
                //Intent intent = new Intent(context, MenuDetailActivity.class);
                //intent.putExtra("selectedMenu", menu);
                //context.startActivity(intent);
                //finish(); // 만약, 현재 액티비티를 종료하고 싶다면 주석 해제
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView menuNameTextView;
        TextView menuPriceTextView;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            menuNameTextView = itemView.findViewById(R.id.menuNameTextView);
            menuPriceTextView = itemView.findViewById(R.id.menuPriceTextView);
        }

        public void bind(Menu menu) {
            menuNameTextView.setText(menu.getName());
            menuPriceTextView.setText(menu.getPrice() + "원");
        }
    }
}