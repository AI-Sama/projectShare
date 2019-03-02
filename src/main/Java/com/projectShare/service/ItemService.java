package com.projectShare.service;


import com.projectShare.Pojo.Items;
import com.projectShare.Pojo.ItemsDevelop;
import com.projectShare.Pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public interface ItemService {
        public String insertItem(MultipartFile f1,MultipartFile f2, Items items, User user);
        public List<ItemsDevelop> selectItems(Integer assortmentId, Integer star);
        public Integer selectCountItem();
        public void deleteItems(Integer id);
        public void changeItem(Items items);
        public List<ItemsDevelop> selectAllAuditingItems();
        public void changeItemState(Integer itemState,Integer id);
        public List<ItemsDevelop> selectItemsForUser(Integer userId,Integer star);
}
