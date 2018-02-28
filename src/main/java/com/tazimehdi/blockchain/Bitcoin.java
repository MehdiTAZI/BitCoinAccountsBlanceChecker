package com.tazimehdi.blockchain;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;

import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.wallet.Wallet;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



public class Bitcoin {

    final static NetworkParameters networkParameters = MainNetParams.get();

    public static NetworkParameters getNetworkParameters(){

        return networkParameters;
    }

    public static ECKey generateKeys() throws NoSuchAlgorithmException {

        final SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        return new ECKey(secureRandom);
    }

    public static long getBalanceOf(final ECKey key){

        Wallet wallet = new Wallet(networkParameters);

        wallet.importKey(key);

        Coin balance = wallet.getBalance();

        return balance.value;
    }

    public static long getBalanceOf(final String publicKey){

        ECKey ecKey = ECKey.fromPublicOnly(publicKey.getBytes());

        return getBalanceOf(ecKey);
    }

}
