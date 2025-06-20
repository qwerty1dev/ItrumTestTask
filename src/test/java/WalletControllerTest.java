import org.example.adapter.in.web.WalletController;
import org.example.adapter.in.web.exception.GlobalExceptionHandler;
import org.example.domain.OperationType;
import org.example.usecase.port.in.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class WalletControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(walletController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void testDeposit() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(walletService).operate(id, OperationType.DEPOSIT, new BigDecimal("1000"));

        mockMvc.perform(post("/api/v1/wallet")
                        .contentType("application/json")
                        .content("{\"walletId\":\"" + id + "\",\"operationType\":\"DEPOSIT\",\"amount\":1000}"))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetBalance() throws Exception {
        UUID id = UUID.randomUUID();
        when(walletService.getBalance(id)).thenReturn(new BigDecimal("5000"));

        mockMvc.perform(get("/api/v1/wallets/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(5000));
    }
}