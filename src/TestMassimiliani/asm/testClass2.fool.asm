push 0
push 7
push 1
push classC
new
lfp
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
lfp
push -2
lfp
add
lw
copy
lw
push 3
add
lc
js
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
lfp
push -2
lfp
add
lw
copy
lw
push 1
add
lc
js
add
add
add
halt

function0:
cfp
lra
push 1
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
push 2
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
push 3
srv
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 4
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

function6:
cfp
lra
push 10
srv
sra
pop
sfp
lrv
lra
js

function7:
cfp
lra
push 20
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
function1
function2
classB:
function3
function1
function4
function5
classC:
function6
function7
function4
function5
classnull:
