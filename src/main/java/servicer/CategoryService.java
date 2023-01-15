package servicer;


import DAO.CategoryRespository;
import dto.DTOCategoty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    public CategoryRespository CategoryRespository;

    public CategoryService(CategoryRespository CategoryRespository) {
        this.CategoryRespository = CategoryRespository;


    }
}
