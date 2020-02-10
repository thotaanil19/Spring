package com.springboot.blockchain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.springboot.blockchain.dao.BlockRepository;
import com.springboot.blockchain.dao.morphia.BlockMorphiaRepository;
import com.springboot.blockchain.domain.Block;
import com.springboot.blockchain.domain.Registration;
import com.springboot.blockchain.util.Utils;

@Service
public class RegistrationService {

	@Autowired
	private BlockMorphiaRepository blockMorphiaRepository;

	@Autowired
	private BlockRepository blockRepository;

	public Boolean saveRegistration(Registration registration) {
		String previousHash = null;
		List<Block> allBlocks = blockRepository.findAll(new Sort(Direction.DESC, "timeStamp"));
		if (!CollectionUtils.isEmpty(allBlocks)) {
			Utils.validateBlockChain(allBlocks);
			Block previousBlock = allBlocks.get(0);
			previousHash = previousBlock.getHash();
		}
		Block block = new Block(registration, previousHash);
		blockMorphiaRepository.save(block);
		return true;
	}

	public List<Block> getRegistrationHistory() {
		List<Block> blockChain = null;
		Optional<List<Block>> optional = blockRepository.findAllByOrderByTimeStampDesc();

		if (optional.isPresent()) {
			blockChain = optional.get();
			Utils.validateBlockChain(blockChain);
		}
		return blockChain;
	}

}
