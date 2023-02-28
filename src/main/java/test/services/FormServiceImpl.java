package test.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.dto.FormDto;
import test.models.Form;
import test.repositories.AccountsRepository;
import test.repositories.FormRepository;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService{
    private final AccountsRepository accountsRepository;
    private final FormRepository formRepository;

    @Override
    public void saveForm(Long accId, FormDto formDto) {
        Form form = Form.builder()
                .account(accountsRepository.getAccountById(accId))
                .favSong(formDto.getFavSong())
                .favDate(formDto.getFavDate())
                .favDish(formDto.getFavDish())
                .favNum(formDto.getFavNum())
                .favColor(formDto.getFavColor())
                .build();
        formRepository.save(form);
    }
}
