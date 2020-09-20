package top.murphypen.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.murphypen.springcloud.mapper.PaymentMapper;
import model.Payment;
import top.murphypen.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentMapper paymentMapper;

	@Override
	public int insertPayment(Payment object) {
		return paymentMapper.insertPayment(object);
	}

	@Override
	public int updatePayment(Payment object) {
		return paymentMapper.updatePayment(object);
	}

	@Override
	public int update(Payment.UpdateBuilder object) {
		return paymentMapper.update(object);
	}

	@Override
	public List<Payment> queryPayment(Payment object) {
		return paymentMapper.queryPayment(object);
	}

	@Override
	public Payment queryPaymentLimit1(Payment object) {
		return paymentMapper.queryPaymentLimit1(object);
	}
}
