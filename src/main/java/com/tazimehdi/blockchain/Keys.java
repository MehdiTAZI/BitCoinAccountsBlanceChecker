package com.tazimehdi.blockchain;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;

public class Keys {

    private ECKey key;
    private String privateKey;
    private String publicKey;


    public Keys(){

    }

    public Keys(final String privateKey, final String publicKey) {

        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public Keys(final ECKey key) {

        Address pubAddress = new Address(Bitcoin.getNetworkParameters(), key.getPubKeyHash());
        DumpedPrivateKey privKey = key.getPrivateKeyEncoded(Bitcoin.getNetworkParameters());

        this.key = key;
        this.privateKey = privKey.toBase58();
        this.publicKey = pubAddress.toBase58();
    }

    public ECKey getKey() {
        return this.key;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }
}
