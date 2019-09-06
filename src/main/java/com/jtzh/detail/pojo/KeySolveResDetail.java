package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.KeyproSource;

public class KeySolveResDetail {
	private KeySolveResponse keySolveResponse;
	private List<KeyproSource> solveSource;

	public KeySolveResponse getKeySolveResponse() {
		return keySolveResponse;
	}

	public void setKeySolveResponse(KeySolveResponse keySolveResponse) {
		this.keySolveResponse = keySolveResponse;
	}

	public List<KeyproSource> getSolveSource() {
		return solveSource;
	}

	public void setSolveSource(List<KeyproSource> solveSource) {
		this.solveSource = solveSource;
	}

}
