package com.ecobike.service.impl;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.app.annotation.Singleton;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.Bicycle;
import com.ecobike.service.PrintService;
import com.ecobike.service.WriterService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.UUID;

@Singleton
public class WriterServiceImpl implements WriterService {

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    @InjectByType
    private PrintService printService;

    @Override
    public void writeToFile(Path filePath) {
        try (OutputStream out = Files.newOutputStream(filePath);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8))) {

            Iterator iterator = dataCache.keys().asIterator();

            int count = 0;
            while(iterator.hasNext()) {
                UUID key = (UUID) iterator.next();
                Bicycle bike = dataCache.get(key);
                writer.write(bike.serialize());

                count++;
            }

            printService.println("There are " + count + " records were written to file");

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
