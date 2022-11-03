package co.edu.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopItem {
	private String itemCode;  //상품 코드
	private String itemName;  //상품이름
	private int originPrice;  //원래 가격
	private int salePrice;    //할인가격
	private double likeIt;       //별점
	private String image;     //이미지
}
