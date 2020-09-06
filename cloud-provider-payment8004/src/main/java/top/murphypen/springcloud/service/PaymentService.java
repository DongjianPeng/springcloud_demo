package top.murphypen.springcloud.service;

import model.Payment;

import java.util.List;

public interface PaymentService {
	int insertPayment(Payment object);

	int updatePayment(Payment object);

	int update(Payment.UpdateBuilder object);

	List<Payment> queryPayment(Payment object);

	Payment queryPaymentLimit1(Payment object);
}
