package com.sample.ecommerce.seller.domain;

import com.sample.ecommerce.store.domain.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`seller`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerSeq;

    private String sellerId;

    private String sellerPassword;

    private String sellerName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    private List<Store> stores = new ArrayList<>();

}
