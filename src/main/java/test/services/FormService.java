package test.services;

import test.dto.FormDto;
import test.models.Form;

public interface FormService {
    void saveForm(Long accId, FormDto form);
}
