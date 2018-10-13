push 0
push 3
push 5
push 2
push classpaperino
new
push 1
push 1
push classpippo
new
push 1
push 1
push classpluto
new
lfp
push -4
lfp
add
lw
push -2
lfp
add
lw
copy
lw
push 2
add
lc
js
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 1
beq label0
push 4
b label1
label0:
push 3
label1:
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 2
push 0
lfp
add
lw
calchoff
add
lw
add
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
lfp
push 1
lfp
add
lw
copy
lw
push 0
add
lc
js
srv
sra
pop
pop
sfp
lrv
lra
js
classpluto:
function1
classpippo:
function0
classpaperino:
function0
function2
function3
classnull:
