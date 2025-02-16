package org.hyeonqz.jpabestexample.nplus1.service;

import org.hyeonqz.jpabestexample.nplus1.repository.NOrderRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NOrderService {
	private final NOrderRepository nOrderRepository;
}
